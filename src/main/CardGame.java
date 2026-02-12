package main;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
    // Name of the card game
    private final String name;

    // The deck of cards used in the game
    private final ArrayList<Card> deckOfCards;

    protected Player firstPlayer;
    protected Player secondPlayer;

    // Constructor: creates a new card game and builds a full deck of 52 cards
    public CardGame(String name) {
        this.name = name;

        // Initialise the deck
        this.deckOfCards = new ArrayList<>();

        Suit[] suits = Suit.values();
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        // Build the full deck by combining every suit with every symbol and value
        for (Suit suit : suits) {
            for (int i = 0; i < symbols.length; i++) {
                deckOfCards.add(new Card(suit, symbols[i], values[i]));
            }
        }
    }

    // Getter: returns the name of the card game
    public String getName() {
        return name;
    }

    // Getter: returns the full deck of cards
    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    // Deals the top card from the deck
    // Returns null if the deck is empty
    public Card dealCard() {
        if (deckOfCards.isEmpty()) return null;
        return deckOfCards.remove(0);
    }

    // Sorts the deck by card value in ascending order
    public void sortDeckInNumberOrder() {
        deckOfCards.sort((a,b) -> a.getValue() - b.getValue());
    }

    // Sorts the deck by suit, then by value within each suit
    public void sortDeckIntoSuits() {
        deckOfCards.sort( (a,b) -> {
            if( a.getSuit() == b.getSuit() ) {
                return a.getValue() - b.getValue();
        }
            return a.getSuit().compareTo( b.getSuit());
    });
    }

    // Randomly shuffles the deck of cards
    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }
}
