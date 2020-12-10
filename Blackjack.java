
import java.util.Scanner;

public class Blackjack {

    private final int BLACKJACK = 21;
    private boolean gameEnded = false;
    private boolean dealerGameEnded = false;
    private boolean userBust = false;
    private boolean dealerBust = false;

    Scanner input = new Scanner(System.in);
    Hand player = new Hand();
    Hand dealer = new Hand();

    public int userPlayGame() {

        player.add();
        player.add();
        System.out.println("Your cards: ");
        player.printCards();
        player.getSumOfHand();

        checkForBust(player);

        if (!gameEnded) {
            do {
                askToDrawOrFold();
            } while (gameEnded != true);
        }

        return player.sumOfCards;

    }

    public int dealerPlayGame() {
        dealer.add();
        dealer.add();

        dealerCheckForBust(dealer);
        if (!dealerGameEnded && dealer.sumOfCards <= 16) {
            while (!dealerGameEnded) {
                dealer.add();
                dealerCheckForBust(dealer);
            }
        } else if (!dealerGameEnded && dealer.sumOfCards > 16) {
            dealerGameEnded = true;
        }

        System.out.println("Dealer finished with " + dealer.sumOfCards);

        return dealer.sumOfCards;
    }

    public void checkWinner() {
        if (userBust && dealerBust) {
            System.out.println("\nBoth lose, both bust");
        } else if (userBust && !dealerBust) {
            System.out.println("\nDealer wins!");
        } else if (!userBust && dealerBust) {
            System.out.println("\nUser wins!");
        } else if (!userBust && !dealerBust) {
            if (player.sumOfCards > dealer.sumOfCards) {
                System.out.println("\nUser wins!");
            } else if (player.sumOfCards < dealer.sumOfCards) {
                System.out.println("\nDealer wins!");
            } else {
                System.out.println("\nThere's a tie!");
            }
        } else {
            System.out.println("\nWtf");
        }
    }

    private void askToDrawOrFold() {
        System.out.println("\nWould you like to draw a card or fold?");
        System.out.println("Please enter " + "\"d\" or " + "\"f\"");
        char s = input.next().charAt(0);
        boolean validInput = false;

        if (s == 'd' || s == 'f') {
            validInput = true;
        } else if (s != 'd' || s != 'f') {
            validInput = false;
        }
        while (!validInput) {

            System.out.println("Invalid input try again");
            s = input.next().charAt(0);
            if (s == 'd' || s == 'f') {
                validInput = true;
            }
        }

        if (s == 'd') {
            gameEnded = false;
            UserHitCard();
        } else if (s == 'f') {
            gameEnded = true;
            UserFold();
        }
    }

    private boolean checkForBust(Hand user) {
        if (user.sumOfCards > BLACKJACK) {
            System.out.println("\nYou busted");
            gameEnded = true;
            userBust = true;
        } else if (user.sumOfCards == BLACKJACK) {
            System.out.println("\nBlackjack!");
            gameEnded = true;
        }
        return gameEnded;
    }

    private boolean dealerCheckForBust(Hand house) {
        if (house.sumOfCards > 21) {
            dealerBust = true;
            dealerGameEnded = true;
            System.out.println("Dealer has bust");
        } else if (house.sumOfCards == 21) {
            System.out.println("Dealer has BlackJack");
            dealerGameEnded = true;
        }

        return dealerBust;
    }

    private void UserHitCard() {
        player.add();
        player.printCards();
        player.getSumOfHand();

        checkForBust(player);
    }

    private void UserFold() {
        player.getSumOfHand();
        gameEnded = true;

    }

}
