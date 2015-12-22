package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.utils.ScoreHelper;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ScoreTest {
    List<Dice> diceList;
    int points;

    @BeforeClass
    public static void initialize() {
        System.out.println("Testing the ScoreHelper class");
    }

    @Before
    public void setUp() {
        diceList = new ArrayList<>();
        points = 0;
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

        points = ScoreHelper.calculatePoints(diceList);
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
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Heading Three of a Kind should score 8 points", 8, points);

        diceList.clear();
        diceList = TestUtils.createMiddleThree();
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Middle Three of a Kind should score 18 points", 18, points);

        diceList.clear();
        diceList = TestUtils.createTrailingThree();
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Trailing Three of a Kind should score 25 points", 25, points);
    }

    @Test
    public void testFourOfAKind() {
        diceList = TestUtils.createHeadingFour();
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Heading Four of a Kind should score 21 points", 21, points);

        diceList = TestUtils.createTrailingFour();
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Trailing Four of a Kind should score 25 points", 25, points);
    }

    @Test
    public void testFourStair() {
        diceList = TestUtils.createHeadingFourStair();
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Heading Four Stair should score 30 points", 30, points);

        diceList = TestUtils.createNestedFourStair();
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Nested Four Stair should score 30 points", 30, points);

        diceList = TestUtils.createTrailingFourStair();
        points = ScoreHelper.calculatePoints(diceList);
        Assert.assertEquals("Trailing Four Stair should score 30 points", 30, points);
    }
}
