package main;
import java.util.Scanner;

public class Snap extends CardGame {

    private final Player p1;
    private final Player p2;

    private Card previousCard;
    private Card currentCard;

    Scanner scanner = new Scanner(System.in);

    public Snap(Player p1, Player p2) {
        super("Snap");
        this.p1 = p1;
        this.p2 = p2;
    }

    public void play() {
        shuffleDeck();
        System.out.println("Welcome to Snap Game");
        System.out.println("Press ENTER to deal a card.");

        boolean gameInProgress = true;
        boolean isPlayerOneTurn = Math.random() < 0.5;

        if (isPlayerOneTurn) {
            System.out.println(p1.getName() + " starts!");
        } else {
            System.out.println(p2.getName() + " starts!");
        }

        previousCard = null;

        while (gameInProgress) {

            Player currentPlayer = isPlayerOneTurn ? p1 : p2;
            System.out.println();
            System.out.println(currentPlayer.getName() + "'s turn - press ENTER:");
            scanner.nextLine();

            currentCard = dealCard();

            if (currentCard == null) {
                System.out.println("No more cards! Game ends in a draw.");
                break;
            }

            System.out.println("Card: " + currentCard);

            if (previousCard == null) {
                previousCard = currentCard;
                isPlayerOneTurn = !isPlayerOneTurn;
                continue;
            }

            if (previousCard.getSymbol().equals(currentCard.getSymbol())) {

                System.out.println("SNAP opportunity! Type 'snap' within 2 seconds!");

                long startTime = System.currentTimeMillis();
                String input = scanner.nextLine();
                long endTime = System.currentTimeMillis();

                boolean typedSnap = input.trim().equalsIgnoreCase("snap");
                boolean inTime = (endTime - startTime) <= 2000;

                if (typedSnap && inTime) {
                    System.out.println("SNAP! " + currentPlayer.getName() + " wins 🎉");
                } else {
                    System.out.println("Too slow or wrong word!");
                    System.out.println(currentPlayer.getName() + " loses 😬");
                }

                gameInProgress = false;

            } else {
                previousCard = currentCard;
                isPlayerOneTurn = !isPlayerOneTurn;
            }
        }
    }
}




