package main;
import java.util.Scanner;

public class Snap extends CardGame {
    private Card previousCard;
    private Card currentCard;
    Scanner scanner = new Scanner(System.in);

    public Snap() {
        super("Snap");
    }

    public void play() {
        shuffleDeck();
        System.out.println("Press ENTER to deal a card.");
    }







}

