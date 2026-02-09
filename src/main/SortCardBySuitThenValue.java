package main;

import java.util.Comparator;

public class SortCardBySuitThenValue implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {

        //compare suits then value
        if( c1.getSuit().equals(c2.getSuit()) ) {
            return Integer.compare(c1.getValue(), c2.getValue());
        }
        return c1.getSuit().compareTo( c2.getSuit() );
    }
}
