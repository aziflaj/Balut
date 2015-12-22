package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.utils.ScoreHelper;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ScoreTest {
    List<Dice> diceList;

    @BeforeClass
    public static void initialize() {
        System.out.println("Testing the ScoreHelper class");
    }

    @Before
    public void setUp() {
        diceList = new ArrayList<>();
    }

    @After
    public void tearDown() {
        diceList.clear();
    }

    @AfterClass
    public static void destroy() {
        System.out.println("Testing finished");
    }

    @Test
    public void testFullHouse() {
        diceList = TestUtils.createFullHouseTestCase();

        int points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Full House should score 25 points", 25, points);

        // Test reversed
        diceList.clear();
        diceList = TestUtils.createReversedFullHouseTestCase();

        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Reversed Full House should score 25 points", 25, points);
    }

    @Test
    public void testThreeOfAKind() {
        diceList = TestUtils.createHeadingThree();
        int points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Heading Three of a Kind should score 18 points", 18, points);

        diceList.clear();
        diceList = TestUtils.createMiddleThree();
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Heading Three of a Kind should score 25 points", 25, points);

        diceList.clear();
        diceList = TestUtils.createTrailingThree();
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Heading Three of a Kind should score 8 points", 8, points);
    }

}
