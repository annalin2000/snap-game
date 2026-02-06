package main.java;
import java.util.Scanner;

public class Snap extends CardGame {

    public Snap(String name) {
        super(name);
    }


    Scanner scanner = new Scanner(System.in);







    public void play() {
        shuffleDeck();
    }
}

