package com.aziflaj.balut.model;

import java.util.Random;

/**
 * The Dice Model
 * <p>
 * This model represents a dice of the game, containing information about
 * different dice state and the rolling value
 */
public class Dice {
    public static final int UNSELECTED = 0;
    public static final int SELECTED = 1;
    public static final int QUESTION_MARK = 2;

    private int state;
    private int value;

    /**
     * Constructs the default dice, with the QUESTION_MARK state and a
     * default -1 value which can't be used
     */
    public Dice() {
        this.state = QUESTION_MARK;
        this.value = -1; // Default value. Shouldn't be used
    }

    /**
     * Rolls the dice, by assigning a random value and the state as UNSELECTED
     */
    public void roll() {
        if (state != SELECTED) {
            Random random = new Random();
            this.value = random.nextInt(6) + 1;
            this.state = UNSELECTED;
        }
    }

    /**
     * @return the state of the dice
     */
    public int getState() {
        return this.state;
    }

    /**
     * @return the value of the dice from 1 to 6 (or -1 when illegal)
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Set the state of the dice to {@code SELECTED}
     */
    public void select() {
        this.state = SELECTED;
    }

    /**
     * Set the state of the dice to {@code UNSELECTED}
     */
    public void unSelect() {
        this.state = UNSELECTED;
    }
}
