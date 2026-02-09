package main;

import java.util.Comparator;

public class SortCardByValue implements Comparator<Card> {
        @Override
        public int compare(Card c1, Card c2) {

            //compare by value
            return Integer.compare(c1.getValue(), c2.getValue());
        }
    }