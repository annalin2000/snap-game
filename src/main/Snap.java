package main;

// Used to read input from the keyboard
import java.util.Scanner;

// Used for time limited input, threads and timeout
import java.util.concurrent.*;

// Snap game class that extends CardGame
public class Snap extends CardGame {

    private static final int SNAP_TIMEOUT_SECONDS = 2;

    // Scanner for user input
    private final Scanner scanner;

    // Stores the previously dealt card
    private Card previousCard;

    // Stores the currently dealt card
    private Card currentCard;

    public Snap(Scanner scanner) {
        super("Snap");
        this.scanner = scanner;
    };

    private void setupPlayers() {

        System.out.println("\nWelcome to Snap Game!");
        System.out.println("Enter player names to begin.\n");

        String playerOneName = "";
        String playerTwoName = "";

        while (playerOneName.isEmpty()) {
            System.out.print("Enter Player 1 name: ");
            playerOneName = scanner.nextLine().trim();
        }

        while (playerTwoName.isEmpty()) {
            System.out.print("Enter Player 2 name: ");
            playerTwoName = scanner.nextLine().trim();
        }

        firstPlayer = new Player(playerOneName);
        secondPlayer = new Player(playerTwoName);
    }


    public void play() {

        setupPlayers();

        // Shuffle the deck before starting the game
        shuffleDeck();

        // Randomly decide who starts
        boolean isPlayerOneTurn = Math.random() < 0.5;
        System.out.println((isPlayerOneTurn ? firstPlayer.getName() : secondPlayer.getName()) + " starts first!");

        // No card has been dealt yet
        previousCard = null;

        while (true) {
            // Decide whose turn it is
            Player currentPlayer = isPlayerOneTurn ? firstPlayer : secondPlayer;

            System.out.println();
            System.out.print(currentPlayer.getName() + "'s turn - Press ENTER to deal a card");
            scanner.nextLine();

            // Deal a card from the deck
            currentCard = dealCard();

            // If there are no more cards, end the game
            if (currentCard == null) {
                System.out.println("No more cards! Game ends in a draw.");
                break;
            }
            // Show the dealt card
            System.out.println(currentPlayer.getName() + " got card: " + currentCard);


            if (previousCard != null && previousCard.getSymbol().equals(currentCard.getSymbol())) {

                System.out.println();
                System.out.println("SNAP! Type 'snap' within " + SNAP_TIMEOUT_SECONDS + " seconds!");

                //Run input on another thread to allow a time limit
                ExecutorService executor = Executors.newSingleThreadExecutor();
                Future<String> future = executor.submit(scanner::nextLine);

                try {
                    // Wait for input up to 2 seconds
                    String input = future.get(SNAP_TIMEOUT_SECONDS, TimeUnit.SECONDS);

                    if ("snap".equalsIgnoreCase(input.trim())) {
                        System.out.println();
                        System.out.println("🎉 SNAP! " + currentPlayer.getName() + " wins!");
                    } else {
                        System.out.println();
                        System.out.println("Wrong word! " + currentPlayer.getName() + " loses!");
                    }

                } catch (TimeoutException e) {
                    System.out.println();
                    System.out.println("⏱️ Time's up! " + currentPlayer.getName() + " loses!");

                } catch (InterruptedException e) {
                    // If the thread was interrupted, restore interrupt flag
                    Thread.currentThread().interrupt();

                } catch (Exception e) {
                    throw new IllegalStateException("Input error occurred");

                } finally {
                    // immediately kill thread
                    executor.shutdown();
                }

                // End game after snap attempt
                return;
            }
            //No snap, move current card into previous card
            previousCard = currentCard;
            // Switch turns
            isPlayerOneTurn = !isPlayerOneTurn;
        }
    }
}
