package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player 1 name: ");
        String playerOneName = scanner.nextLine();

        Player p1 = new Player(playerOneName);

        System.out.print("Enter Player 2 name: ");
        String playerTwoName = scanner.nextLine();
        Player p2 = new Player(playerTwoName);

        Snap snap = new Snap(p1, p2);
        snap.play();
    }
}

