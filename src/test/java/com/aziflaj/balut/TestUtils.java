package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUtils {

    private static Dice createDiceWithValue(int value) {
        Dice d = new Dice();
        do {
            d.roll();
        } while (d.getValue() != value);
        return d;
    }

    public static List<Dice> createFullHouseTestCase() {
        List<Dice> diceList = new ArrayList<>();

        // make THREE 1s
        for (int i = 0; i < 3; i++) {
            diceList.add(createDiceWithValue(1));
        }

        // make TWO 5s
        for (int i = 0; i < 2; i++) {
            diceList.add(createDiceWithValue(5));
        }

        Collections.shuffle(diceList);
        return diceList;
    }

    public static List<Dice> createReversedFullHouseTestCase() {
        List<Dice> diceList = new ArrayList<>();

        // make TWO 2s
        for (int i = 0; i < 2; i++) {
            diceList.add(createDiceWithValue(2));
        }

        // make THREE 3s
        for (int i = 0; i < 3; i++) {
            diceList.add(createDiceWithValue(3));
        }

        Collections.shuffle(diceList);
        return diceList;
    }

    public static List<Dice> createHeadingThree() {
        List<Dice> diceList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            diceList.add(createDiceWithValue(4));
        }

        diceList.add(createDiceWithValue(1));
        diceList.add(createDiceWithValue(5));
        Collections.shuffle(diceList);

        // score should be 4 * 3 + 1 + 5 = 18
        return diceList;
    }

    public static List<Dice> createMiddleThree() {
        List<Dice> diceList = new ArrayList<>();

        diceList.add(createDiceWithValue(2));

        for (int i = 0; i < 3; i++) {
            diceList.add(createDiceWithValue(6));
        }

        diceList.add(createDiceWithValue(5));
        Collections.shuffle(diceList);

        // score should be 2 + 6 * 3 + 5 = 25
        return diceList;
    }

    public static List<Dice> createTrailingThree() {
        List<Dice> diceList = new ArrayList<>();

        diceList.add(createDiceWithValue(2));
        diceList.add(createDiceWithValue(3));

        for (int i = 0; i < 3; i++) {
            diceList.add(createDiceWithValue(1));
        }

        Collections.shuffle(diceList);

        // score should be 2 + 3 + 1 * 3 = 8
        return diceList;
    }
}
