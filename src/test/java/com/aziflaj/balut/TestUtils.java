package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUtils {

    public static List<Dice> createFullHouseTestCase() {
        List<Dice> diceList = new ArrayList<>();

        // make THREE 1s
        for (int i = 0; i < 3; i++) {
            Dice d = new Dice();
            do {
                d.roll();
            } while (d.getValue() != 1);

            // Now that value = 1, add the dice in the list
            diceList.add(d);
        }

        // make TWO 5s
        for (int i = 0; i < 2; i++) {
            Dice d = new Dice();
            do {
                d.roll();
            } while (d.getValue() != 5);

            // Now that value = 5, add the dice in the list
            diceList.add(d);
        }

        Collections.shuffle(diceList);
        return diceList;
    }

    public static List<Dice> createReversedFullHouseTestCase() {
        List<Dice> diceList = new ArrayList<>();

        // make TWO 2s
        for (int i = 0; i < 2; i++) {
            Dice d = new Dice();
            do {
                d.roll();
            } while (d.getValue() != 2);

            // Now that value = 2, add the dice in the list
            diceList.add(d);
        }

        // make THREE 3s
        for (int i = 0; i < 3; i++) {
            Dice d = new Dice();
            do {
                d.roll();
            } while (d.getValue() != 3);

            // Now that value = 3, add the dice in the list
            diceList.add(d);
        }

        Collections.shuffle(diceList);

        return diceList;
    }
}
