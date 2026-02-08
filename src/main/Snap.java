package main;
import java.util.Scanner;

public class Snap extends CardGame {
    private Player p1;
    private Player p2;
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
        System.out.println("Each turn is random!");
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

            if (isPlayerOneTurn) {
                System.out.println();
                System.out.println(p1.getName() + "'s turn - press ENTER:");
            } else {
                System.out.println();
                System.out.println(p2.getName() + "'s turn - press ENTER:");
            }

            scanner.nextLine();

            currentCard = dealCard();
            System.out.println("Card: " + currentCard);

            if (previousCard == null) {
                previousCard = currentCard;
                if (playerOneTurn) {
                    playerOneTurn = false;
                } else {
                    playerOneTurn = true;
                }
            }

            else if (previousCard.getSymbol().equals(currentCard.getSymbol())) {
                System.out.println("SNAP! You win 🎉");
                gameInProgress = false;
            }
            else {
                previousCard = currentCard;
                }
            }
        }








}

