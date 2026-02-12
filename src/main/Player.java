package main;

// Represents a player in the game
public class Player {

    // Stores the player's name
    private final String name;
    private int points;


    // Constructor: creates a Player with the given name
    public Player(String name) {
        this.name = name.trim();
    }

    // Getter: returns the player's name
    public String getName() {
        return name;
    }

    // Add 1 point when player wins
    public void addPoint() {
        points++;
    }

    // Get total points
    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + " - Points: " + points;
    }
}
