package main;

import java.util.Scanner;

public class Snap extends CardGame {

    private static final long SNAP_TIME_LIMIT_MS = 2000;

    private final Player p1;
    private final Player p2;
    Scanner scanner = new Scanner(System.in);

    private Card previousCard;
    private Card currentCard;

    public Snap(Player p1, Player p2) {
        super("Snap");
        this.p1 = p1;
        this.p2 = p2;
    }


    public void play() {
        shuffleDeck();
        System.out.println("Welcome to Snap Game. Press ENTER to deal a card.");

        boolean isPlayerOneTurn = Math.random() < 0.5;
        System.out.println((isPlayerOneTurn ? p1.getName() : p2.getName()) + " starts first!");

        previousCard = null;

        while (true) {
            Player currentPlayer = isPlayerOneTurn ? p1 : p2;

            System.out.println();
            System.out.print(currentPlayer.getName() + "'s turn - Press ENTER to deal a card");
            scanner.nextLine();

            currentCard = dealCard();

            if (currentCard == null) {
                System.out.println("No more cards! Game ends in a draw.");
                return;
            }

            System.out.println(currentPlayer.getName() + " got card: " + currentCard);

            if (previousCard == null) {
                previousCard = currentCard;
                isPlayerOneTurn = !isPlayerOneTurn;
                continue;
            }

            if (previousCard.getSymbol().equals(currentCard.getSymbol())) {
                System.out.println();
                System.out.println("SNAP opportunity! Type 'snap' within 2 seconds!");

                long startTime = System.currentTimeMillis();
                String input = scanner.nextLine();
                long endTime = System.currentTimeMillis();

                boolean typedSnap = input.trim().equalsIgnoreCase("snap");
                boolean inTime = (endTime - startTime) <= SNAP_TIME_LIMIT_MS;

                if (typedSnap && inTime) {
                    System.out.println();
                    System.out.println("SNAP! " + currentPlayer.getName() + " wins 🎉");
                } else {
                    System.out.println();

                    if(!typedSnap) {
                        System.out.println("Wrong word! You must type 'snap'");
                    }
                    if (!inTime) {
                        System.out.println("Too slow! You took more than 2 seconds");
                    }

                    System.out.println(currentPlayer.getName() + " loses 😬");
                }

                return;

            } else {
                previousCard = currentCard;
                isPlayerOneTurn = !isPlayerOneTurn;
            }
        }
    }
}




