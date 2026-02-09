package main;

import java.util.ArrayList;
import java.util.Collections;


public class CardGame {
    private final String name;
    private final ArrayList<Card> deckOfCards;


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

    public String getName() {
        return name;
    }

    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    public Card dealCard() {
        if (deckOfCards.isEmpty()) return null;
        return deckOfCards.remove(0);
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards, new SortCardByValue());
        return deckOfCards;
    }


    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(deckOfCards, new SortCardBySuitThenValue());
        return deckOfCards;
    }



    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}
