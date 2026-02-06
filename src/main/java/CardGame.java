package main.java;

import java.util.ArrayList;

public class CardGame {
    private String name;
    private ArrayList<Card> deckOfCards;


    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();

        String[] suits = {"♥", "♦", "♣", "♠"};
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String suit : suits) {
            for (int i = 0; i < symbols.length; i++) {
                deckOfCards.add(new Card(suit, symbols[i], values[i]));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }
}
