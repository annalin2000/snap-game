package main;

// Represents a single playing card
public class Card {
    private final Suit suit;
    private final String symbol;
    private final int value;

    // Constructor: creates a new Card with a suit, symbol, and value
    public Card(Suit suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    // Getter: returns the suit of the card
    public Suit getSuit() {
        return suit;
    }

    // Getter: returns the symbol of the card
    public String getSymbol() {
        return symbol;
    }

    // Getter: returns the numeric value of the card
    public int getValue() {
        return value;
    }

    // Converts the card object into a readable String
    @Override
        public String toString() {
        String suitSymbol = switch (suit) {
            case hearts -> "♥";
            case diamonds -> "♦";
            case clubs -> "♣";
            case spades -> "♠";
        };
        return suitSymbol + symbol;
    }
}
