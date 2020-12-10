
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        boolean keepPlaying = false;

        do {
            System.out.println("Welcome to Blackjack\nYou are playing the dealer");
            System.out.println("Dealer deals cards..\n");

            TimeUnit.SECONDS.sleep(2);

            Blackjack game = new Blackjack();
            game.userPlayGame();
            game.dealerPlayGame();

            TimeUnit.SECONDS.sleep(1);
            game.checkWinner();

            System.out.println("\nWould you like to play again?\nEnter 'y' to play again or any other key to quit");
            char s = input.next().charAt(0);
            if (s == 'y'){
                keepPlaying = true;
                System.out.println();
            }
            else {
                keepPlaying = false; 
            }
        } while (keepPlaying);
    }
}
