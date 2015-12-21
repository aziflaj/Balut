package com.aziflaj.balut.model;

/**
 * The Player model
 * <p>
 * This class represents a player of the game, containing information about
 * the player and his points. It also handles the addition of more points
 * and the persistence of the Player instance in the database.
 */
public class Player {
    String mName;
    int mPoints;

    /**
     * Protected empty constructor with no parameters which shouldn't be used
     */
    protected Player() {
    }

    /**
     * Creates a new player with the given name and no points
     *
     * @param name The name of the player
     */
    public Player(String name) {
        this.mName = name;
        this.mPoints = 0;
    }

    /**
     * @return The points of the player
     */
    public int getPoints() {
        return this.mPoints;
    }

    /**
     * Adds more points to the player, after a lucky dice roll
     *
     * @param points The points to add to the player
     */
    public void addPoints(int points) {
        this.mPoints += points;
    }

    /**
     * Stores the user in the database.
     * TODO: Should be implemented after the database is connected
     */
    public void persist() {
        System.out.println("Persisting player " + this.mName);
    }
}
