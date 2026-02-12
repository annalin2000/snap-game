package main;

// Represents a player in the game
public class Player {

    // Stores the player's name
    private String name;

    public Player() {}

    // Constructor: creates a Player with the given name
    public Player(String name) {
        this.name = name;
    }

    // Getter: returns the player's name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
