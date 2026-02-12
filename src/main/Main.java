package main;

import java.util.Scanner;

public class Main {

    public static void printInstructions(Scanner scanner) {
        System.out.println("\n=== HOW TO PLAY SNAP ====");
        System.out.println("1. Players take turns pressing ENTER to deal a card.");
        System.out.println("2. Watch the symbols carefully.");
        System.out.println("3. If two cards in a row have the same symbol, it's SNAP!");
        System.out.println("4. Type 'snap' within 2 seconds.");
        System.out.println("5. Correct snap = 1 point.");
        System.out.println("6. Wrong word or too slow = 0 points.");
        System.out.println("7. When you exit, the player with fewer points loses.");
        System.out.println("=========================");

        System.out.println("\n1 - Back to Menu");
        System.out.print("Choose option: ");

        while (true) {
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) return;

            System.out.print("\nInvalid option. Please enter correct option: ");
        }
    }

    private static String readNonEmptyName(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) return name;
            System.out.println("Name cannot be empty. Please try again.\n");
        }
    }

    private static void finalResult(Player player1, Player player2) {

        System.out.println("\n========== FINAL RESULT ==========");
        System.out.println(player1.getName() + " - Points: " + player1.getPoints());
        System.out.println(player2.getName() + " - Points: " + player2.getPoints());
        System.out.println("-----------------------------------");

        if (player1.getPoints() > player2.getPoints()) {
            System.out.println("🏆 " + player1.getName() + " wins the game!");
            System.out.println("💔 " + player2.getName() + " loses the game.");
        }
        else if (player2.getPoints() > player1.getPoints()) {
            System.out.println("🏆 " + player2.getName() + " wins the game!");
            System.out.println("💔 " + player1.getName() + " loses the game.");
        }
        else {
            System.out.println("🤝 It's a draw! You both scored the same points!");
        }
        System.out.println("===================================\n");
    }

    private static boolean showMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nWelcome to Snap Game! Choose from the following options");
            System.out.println("1 - Read Instructions");
            System.out.println("2 - Start Game");
            System.out.print("Choose option 1 or 2 : ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                printInstructions(scanner);
            } else if (choice.equals("2")) {
                return true;
            } else {
                System.out.println("Invalid option. Please enter 1 or 2.\n");
            }
        }
    }


    public static void main(String[] args) {

        // Scanner used to read input from the user
        Scanner scanner = new Scanner(System.in);

        showMenu(scanner);
        System.out.println("\nEnter player names to begin.\n");

        Player p1 = new Player(readNonEmptyName(scanner, "Enter Player 1 name: "));
        Player p2 = new Player(readNonEmptyName(scanner, "Enter Player 2 name: "));

        boolean playAgain = true;

        while (playAgain) {

            // Create a new Snap game using the two players
            Snap snap = new Snap(scanner, p1, p2);

            // Start the Snap game
            snap.play();

            System.out.println("\n=== TOTAL SCOREBOARD ===");
            System.out.println(p1.getName() + " - Points: " + p1.getPoints());
            System.out.println(p2.getName() + " - Points: " + p2.getPoints());

            //Restart
            while (true) {
                System.out.print("\nDo you want to play again? (y/n): ");
                String answer = scanner.nextLine().trim().toLowerCase();

                if (answer.trim().equals("y")) {
                    playAgain = true;
                    System.out.println();
                    break;
                } else if (answer.trim().equals("n")) {
                    playAgain = false;
                    System.out.println();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            }
        }
        finalResult(p1, p2);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}