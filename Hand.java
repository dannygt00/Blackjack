
import java.util.ArrayList;

public class Hand {

    Deck d = new Deck();
    ArrayList<Card> hand = new ArrayList<>();
    int sumOfCards = 0;

    public Hand() {
        d.shuffle();

    }
//ADD VALUE OF THAT CARD AUTO TO SUM OF CARDS

    public void add() {
        Card current = d.dealCard(); 
        hand.add(current);
        
        sumOfCards += current.getValue();
    }

    public void printCards() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println("Card " + (i + 1) + " = " + hand.get(i));
        }

    }

    public int size() {
        return hand.size();
    }

    public int getSumOfHand() {

        System.out.println("Sum = " + sumOfCards);

        return sumOfCards;

    }

}
