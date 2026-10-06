import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(10);
        CardStack discardPile = new CardStack(10);
        // if it isn't obvious, this basically sets up the cards for the activity.
        // there's 30 cards, only 10 can be in the player's hand and only 10 in the discard pile

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 30; i++) {
            playerDeck.push(new TheCard("Card " + i));
        }

        // if i forget, this is basically "while the player deck is not empty, continue"
        while (!playerDeck.isEmpty()) {
            int command = random.nextInt(3);
            int x = random.nextInt(5) + 1;
            // the core of the game; the int command generates a number between 1-3;
            // since java counts 0 first to 2, it's actually 0-2
            // meanwhile the int x = random.nextInt is basically how many cards would be retrieved, drawn or thrown away
            if (command == 0) {
                System.out.println("Draw " + x + " cards");

                for (int i = 0; i < x && !playerDeck.isEmpty(); i++) {
                    playerHand.push(playerDeck.pop());
                }
            } else if (command == 1) {
                System.out.println("Get " + x + " cards from discarded pile. Lucky you.");

                for (int i = 0; i < x && !discardPile.isEmpty(); i++) {
                    playerHand.push(discardPile.pop());
                }

            } else {

                    System.out.println("Throw away " + x + " cards. Womp, womp.");

                    for (int i = 0; i < x && !playerHand.isEmpty(); i++) {
                        discardPile.push(playerHand.pop());
                    }
            }
            // these basically keep track of your progress or stats.
            System.out.println("\nPlayer Hand:");
            playerHand.printStack();

            System.out.println("\nPlayer Deck  | Remaining cards: " + playerDeck.size());

            System.out.println("Discard Pile | Cards in your discard pile: " + discardPile.size());

            if (!playerDeck.isEmpty()) {
                System.out.println("\nPress ENTER to continue.");
                scanner.nextLine();
            }
        }
        // basically flavor text; but this is added when you have no more cards anymore.
        System.out.println("\nYour deck doesn't have anymore cards, no sortie.");
        System.out.println("\n\n+-~[!] GAME OVER [!]~-+");
    }
}