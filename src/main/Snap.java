package main;

// Used to read input from the keyboard
import java.io.IOException;
import java.util.Scanner;

// Snap game class that extends CardGame
public class Snap extends CardGame {

    private static final int SNAP_TIMEOUT_SECONDS = 2;

    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    private final Scanner scanner;

    // Stores the previously dealt card
    private Card previousCard;

    // Stores the currently dealt card
    private Card currentCard;

    public Snap(Scanner scanner, Player player1, Player player2) {
        super("Snap");
        this.scanner = scanner;
        this.firstPlayer = player1;
        this.secondPlayer = player2;
    }

    private String green(String text) {
        return GREEN + text + RESET;
    }

    private String red(String text) {
        return RED + text + RESET;
    }


    private String readLineWithTimeoutSeconds(int seconds) {
        long endTime = System.currentTimeMillis() + (seconds * 1000L);

        try {
            while (System.currentTimeMillis() < endTime) {

                if (System.in.available() > 0) {
                    return scanner.nextLine();
                }

                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void play() {

        // Shuffle the deck before starting the game
        shuffleDeck();

        // Randomly decide who starts
        boolean isPlayerOneTurn = Math.random() < 0.5;
        System.out.println();
        System.out.println((isPlayerOneTurn ? firstPlayer.getName() : secondPlayer.getName()) + " starts first!");

        // No card has been dealt yet
        previousCard = null;

        while (true) {
            // Decide whose turn it is
            Player currentPlayer = isPlayerOneTurn ? firstPlayer : secondPlayer;

            System.out.println();
            System.out.print(currentPlayer.getName() + "'s turn - Press ENTER to deal a card: ");
            scanner.nextLine();

            // Deal a card from the deck
            currentCard = dealCard();

            // If there are no more cards, end the game
            if (currentCard == null) {
                System.out.println("\nNo more cards! It's a draw.");
                break;
            }
            // Show the dealt card
            System.out.println(currentPlayer.getName() + " got card:");
            System.out.println(currentCard);


            if (previousCard != null && previousCard.getSymbol().equals(currentCard.getSymbol())) {

                System.out.println();
                System.out.println("SNAP! Type 'snap' within " + SNAP_TIMEOUT_SECONDS + " seconds!");

                String input = readLineWithTimeoutSeconds(SNAP_TIMEOUT_SECONDS);

                if (input != null && input.trim().equalsIgnoreCase("snap")) {
                    currentPlayer.addPoint();
                    System.out.println(green("\n🎉 SNAP! " + currentPlayer.getName()
                            + " gets 1 point! Total points: " + currentPlayer.getPoints()));
                } else if (input == null) {
                    System.out.println(red("\n⏱️ Time's up! No point awarded."));
                } else {
                    System.out.println(red("\nWrong word! No point awarded."));
                }
                return;

            }
            //No snap, move current card into previous card
            previousCard = currentCard;
            // Switch turns
            isPlayerOneTurn = !isPlayerOneTurn;
        }
    }
}
