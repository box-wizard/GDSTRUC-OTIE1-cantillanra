import java.util.Random;
import java.util.Scanner;

// this is basically the main matchmaking algorithm.

public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int gameCount = 0;
        int playerId = 1;

        System.out.println("[===] About time we started this game, yeah? Let's get to matchmaking. [===]");

        // this entire big chunk of code runs while there are fewer than 10 games
        while (gameCount < 10) {
            int incomingPlayers = random.nextInt(5) + 1; // if it isn't obvious, this is a randomized set. wherein 1-5 players can join.
            System.out.println("\nEnqueuing " + incomingPlayers + " new player(s)...");

            // this is a for loop to create each individual player
            // for example, it can name them from User 1, User 2, etc. then gives them a random level.
            for (int i = 0; i < incomingPlayers; i++) {
                Player player = new Player(
                        playerId,
                        "Player " + playerId,
                        random.nextInt(100) + 1
                );
                queue.enqueue(player);
                playerId++;
            }


            System.out.println("Current Queue:");
            queue.printQueue();

            // this basically forms the game when 5 players are already in there.
            while (queue.size() >= 5 && gameCount < 10) {
                gameCount++;
                System.out.println("\n----------------------------------");
                System.out.println("Game " + gameCount + " is ready.");

                for (int i = 0; i < 5; i++) {
                    System.out.println("   Matched: " + queue.dequeue());
                }
                System.out.println("Game " + gameCount + " successfully started! Good luck, have fun.");
                System.out.println("----------------------------------");
            }

            System.out.println("\nRemaining players in queue: " + queue.size());

            if (gameCount < 10) {
                System.out.println("Press ENTER for the next cycle.");
                scanner.nextLine();
            }
        }

        System.out.println("\nAll 10 games have been successfully formed. Test's over. Time to clock out, yeah?");
        scanner.close();
    }
}