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
        System.out.println("Press ENTER to deal a card.");

        boolean gameInProgress = true;
        previousCard = null;

        while (gameInProgress) {

            scanner.nextLine();

            currentCard = dealCard();
            System.out.println("Card: " + currentCard);

            if (previousCard == null) {
                previousCard = currentCard;
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

