package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.utils.ScoreHelper;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class ScoreTest {

    @BeforeClass
    public static void initialize() {
        System.out.println("Testing the ScoreHelper class");
    }

    @AfterClass
    public static void destroy() {
        System.out.println("Testing finished");
    }

    @Test
    public void testFullHouse() {
        List<Dice> diceList = TestUtils.createFullHouseTestCase();

        int points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Full House should score 25 points", 25, points);
    }

    @Test
    public void testReversedFullHouse() {
        List<Dice> diceList = TestUtils.createReversedFullHouseTestCase();

        int points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Full House should score 25 points", 25, points);
    }

}
