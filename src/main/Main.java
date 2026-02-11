package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner used to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask for Player 1's name and create Player 1
        System.out.print("Enter Player 1 name: ");
        String playerOneName = scanner.nextLine();
        Player p1 = new Player(playerOneName);

        // Ask for Player 2's name and create Player 2
        System.out.print("Enter Player 2 name: ");
        String playerTwoName = scanner.nextLine();
        Player p2 = new Player(playerTwoName);

        // Create a new Snap game using the two players
        Snap snap = new Snap(p1, p2);

        // Start the Snap game
        snap.play();
    }
}

