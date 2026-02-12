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