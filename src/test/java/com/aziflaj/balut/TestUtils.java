package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for creating different Test Cases
 */
public class TestUtils {

    /**
     * Creates a new {@code Dice} instance with the given value
     *
     * @param value The value of the dice
     * @return A {@code Dice} instance witht the given value
     */
    private static Dice createDiceWithValue(int value) {
        Dice d = new Dice();
        do {
            d.roll();
        } while (d.getValue() != value);
        return d;
    }

    /**
     * Creates a Full House test case: three dice with the same value,
     * and two other dice with the same value. (like 3, 3, 3, 5, 5)
     *
     * @return a Full House test case
     */
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

    /**
     * Creates a reversed Full House test case: two dice with the same value,
     * and three other dice with the same value. (like 2, 2, 3, 3, 3)
     *
     * @return A reversed Full House test case
     */
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

    /**
     * Creates a Three of a Kind with all three in the heading
     * (1, 1, 1, 2, 3)
     *
     * @return A Three of a Kind test case
     */
    public static List<Dice> createHeadingThreeTestCase() {
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

    /**
     * Creates a Three of a Kind with all three in the middle
     * (1, 4, 4, 4, 5)
     *
     * @return A Three of a Kind test case
     */
    public static List<Dice> createMiddleThreeTestCase() {
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

    /**
     * Creates a Three of a Kind with all three in the end
     * (2, 5, 6, 6, 6)
     *
     * @return A Three of a Kind test case
     */
    public static List<Dice> createTrailingThreeTestCase() {
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

    /**
     * Creates a Four of a Kind test case, with all four in the head
     * (4, 4, 4, 4, 5)
     *
     * @return A Four of a Kind test case
     */
    public static List<Dice> createHeadingFourTestCase() {
        List<Dice> diceList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            diceList.add(createDiceWithValue(4));
        }

        diceList.add(createDiceWithValue(5));
        Collections.shuffle(diceList);

        // score should be 4 * 4 + 5 = 21
        return diceList;
    }

    /**
     * Creates a Four of a Kind test case, with all four in the end
     * (1, 6, 6, 6, 6)
     *
     * @return A Four of a Kind test case
     */
    public static List<Dice> createTrailingFourTestCase() {
        List<Dice> diceList = new ArrayList<>();

        diceList.add(createDiceWithValue(1));

        for (int i = 0; i < 4; i++) {
            diceList.add(createDiceWithValue(6));
        }

        Collections.shuffle(diceList);

        // score should be 4 * 4 + 5 = 21
        return diceList;
    }

    /**
     * Creates a Four Stair with all four in the beginning
     * (3, 4, 5, 6, 6)
     *
     * @return A Four Stair test case
     */
    public static List<Dice> createHeadingFourStairTestCase() {
        List<Dice> diceList = new ArrayList<>();

        for (int i = 3; i <= 6; i++) {
            diceList.add(createDiceWithValue(i));
        }

        diceList.add(createDiceWithValue(6));

        return diceList;
    }

    /**
     * Creates a nested Four Stair
     * (2, 3, 3, 4, 5)
     *
     * @return A Four Stair test case
     */
    public static List<Dice> createNestedFourStairTestCase() {
        List<Dice> diceList = new ArrayList<>();

        for (int i = 2; i <= 5; i++) {
            diceList.add(createDiceWithValue(i));
        }

        diceList.add(createDiceWithValue(3));

        return diceList;
    }

    /**
     * Creates a Four Stair with all four in the end
     * (3, 3, 4, 5, 6)
     *
     * @return A Four Stair test case
     */
    public static List<Dice> createTrailingFourStairTestCase() {
        List<Dice> diceList = new ArrayList<>();

        for (int i = 3; i <= 6; i++) {
            diceList.add(createDiceWithValue(i));
        }

        diceList.add(createDiceWithValue(3));

        return diceList;
    }

    /**
     * Creates a small Five Stair (1, 2, 3, 4, 5)
     *
     * @return A Five Stair test case
     */
    public static List<Dice> createSmallFiveStairTestCase() {
        List<Dice> diceList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            diceList.add(createDiceWithValue(i));
        }

        return diceList;
    }

    /**
     * Creates a small Five Stair (2, 3, 4, 5, 6)
     *
     * @return A Five Stair test case
     */
    public static List<Dice> createBigFiveStairTestCase() {
        List<Dice> diceList = new ArrayList<>();

        for (int i = 2; i <= 6; i++) {
            diceList.add(createDiceWithValue(i));
        }

        return diceList;
    }

    /**
     * Creates a random test case where all the dice are the same
     *
     * @return A Five of a Kind test case
     */
    public static List<Dice> createFiveOfAKindTestCase() {
        List<Dice> diceList = new ArrayList<>();

        Dice random = new Dice();
        random.roll(); // got a value

        for (int i = 0; i < 5; i++) {
            diceList.add(random);
        }

        return diceList;
    }
}
