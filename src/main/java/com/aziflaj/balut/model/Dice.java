package com.aziflaj.balut.model;

import java.util.Random;

public class Dice {
    public static final int UNSELECTED = 0;
    public static final int SELECTED = 1;

    private int state;
    private int value;

    public Dice() {
        this.state = UNSELECTED;
        this.value = -1; // Default value. Shouldn't be used
    }

    public void roll() {
        Random random = new Random();
        this.value = random.nextInt(6) + 1;
    }

    public int getState() {
        return this.state;
    }

    public int getValue() {
        return this.value;
    }

    // TODO: not related to the model, but related to the view and/or presenter
    public void select() {
        this.state = SELECTED;
    }

    // TODO: not related to the model, but related to the view and/or presenter
    public void unSelect() {
        this.state = UNSELECTED;
    }
}
