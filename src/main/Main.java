package main;

import java.util.Scanner;

public class Main {

    public static String[] getNameInputs(Scanner scanner) {
        String playerOneName = "";
        String playerTwoName = "";

        while (playerOneName.isEmpty()) {
            System.out.print("Enter Player 1 name: ");
            playerOneName = scanner.nextLine();
        }

        while (playerTwoName.isEmpty()) {
            System.out.print("Enter Player 2 name: ");
            playerTwoName = scanner.nextLine();
        }

        return new String[]{playerOneName, playerTwoName};
    };

    public static void printInstructions() {
        System.out.println("\n=== HOW TO PLAY SNAP ===");
        System.out.println("1. Players take turns pressing ENTER to deal a card.");
        System.out.println("2. Watch the symbols of the cards carefully.");
        System.out.println("3. If two cards in a row have the same symbol (i.e. two Kings, two 7s), it's SNAP!");
        System.out.println("4. The current player has 2 seconds to type 'snap'.");
        System.out.println("5. Type it in time to win. Too slow or wrong, you lose.");
        System.out.println("=========================\n");
    }

    public static void main(String[] args) {

        // Scanner used to read input from the user
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {

            //Menu
            while (true) {
                System.out.println("=== SNAP GAME ===");
                System.out.println("1 - Read Instructions");
                System.out.println("2 - Start Game");
                System.out.print("Choose option 1 or 2: ");

                String choice = scanner.nextLine().trim();

                if (choice.equals("1")) {
                    printInstructions();
                } else if (choice.equals("2")) {
                    // exit menu loop and start game
                    break;
                } else {
                    System.out.println("Invalid option. Please enter 1 or 2.\n");
                }
            }

            // Create a new Snap game using the two players
            Snap snap = new Snap();
            snap.takePlayerNameInputs(Main.getNameInputs(scanner));

            // Start the Snap game
            snap.play();

            //Restart
            while (true) {
                System.out.print("\nDo you want to play again? (y/n): ");
                String answer = scanner.nextLine().trim().toLowerCase();

                if (answer.equals("y")) {
                    playAgain = true;
                    System.out.println();
                    break;
                } else if (answer.equals("n")) {
                    playAgain = false;
                    System.out.println();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            }
        }
        System.out.println("\nThanks for playing!");
        scanner.close();
    }
}