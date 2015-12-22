package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.utils.ScoreHelper;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreTest {
    List<Dice> diceList;

    @BeforeClass
    public static void initialize() {
        System.out.println("Testing the ScoreHelper class");
    }

    @AfterClass
    public static void destroy() {
        System.out.println("Testing finished");
    }

    @Before
    public void setUp() {
        diceList = new ArrayList<>();
    }

    @After
    public void tearDown() {
        diceList.clear();
    }

    @Test
    public void testFullHouse23() {
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

        int points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Full House should score 25 points", 25, points);
    }

    @Test
    public void testFullHouse32() {
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

        int points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Full House should score 25 points", 25, points);
    }

}
