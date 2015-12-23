package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.utils.GameCategory;
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

    @AfterClass
    public static void destroy() {
        System.out.println("Testing finished");
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

    @Test
    public void testFullHouse() {
        diceList = TestUtils.createFullHouseTestCase();

        points = ScoreHelper.calculatePoints(diceList, GameCategory.FULL_HOUSE);
        Assert.assertEquals("Full House should score 25 points", 25, points);

        // Test reversed
        diceList.clear();
        diceList = TestUtils.createReversedFullHouseTestCase();

        points = ScoreHelper.calculatePoints(diceList, GameCategory.FULL_HOUSE);
        Assert.assertEquals("Reversed Full House should score 25 points", 25, points);
    }

    @Test
    public void testThreeOfAKind() {
        diceList = TestUtils.createHeadingThreeTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.THREE_OF_A_KIND);
        Assert.assertEquals("Heading Three of a Kind should score 8 points", 8, points);

        diceList.clear();
        diceList = TestUtils.createMiddleThreeTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.THREE_OF_A_KIND);
        Assert.assertEquals("Middle Three of a Kind should score 18 points", 18, points);

        diceList.clear();
        diceList = TestUtils.createTrailingThreeTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.THREE_OF_A_KIND);
        Assert.assertEquals("Trailing Three of a Kind should score 25 points", 25, points);
    }

    @Test
    public void testFourOfAKind() {
        diceList = TestUtils.createHeadingFourTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FOUR_OF_A_KIND);
        Assert.assertEquals("Heading Four of a Kind should score 21 points", 21, points);

        diceList = TestUtils.createTrailingFourTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FOUR_OF_A_KIND);
        Assert.assertEquals("Trailing Four of a Kind should score 25 points", 25, points);
    }

    @Test
    public void testFourStair() {
        diceList = TestUtils.createHeadingFourStairTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FOUR_STAIR);
        Assert.assertEquals("Heading Four Stair should score 30 points", 30, points);

        diceList = TestUtils.createNestedFourStairTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FOUR_STAIR);
        Assert.assertEquals("Nested Four Stair should score 30 points", 30, points);

        diceList = TestUtils.createTrailingFourStairTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FOUR_STAIR);
        Assert.assertEquals("Trailing Four Stair should score 30 points", 30, points);
    }

    @Test
    public void testFiveStair() {
        diceList = TestUtils.createSmallFiveStairTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FIVE_STAIR);
        Assert.assertEquals("Small Five Stair should score 40 points", 40, points);

        diceList = TestUtils.createBigFiveStairTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FIVE_STAIR);
        Assert.assertEquals("Big Five Stair should score 40 points", 40, points);
    }

    @Test
    public void testFiveOfAKind() {
        diceList = TestUtils.createFiveOfAKindTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FIVE_OF_A_KIND);
        Assert.assertEquals("Five of a Kind should score 50", 50, points);
    }

    @Test
    public void testAllCases() {
        diceList = TestUtils.createFullHouseTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.ANY_CASE);
        Assert.assertEquals("Any Case should score 13", 13, points);
    }

    @Test
    public void testSingles() {
        diceList = TestUtils.createFullHouseTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.ONES);
        Assert.assertEquals("Ones should score 3", 3, points);

        points = ScoreHelper.calculatePoints(diceList, GameCategory.TWOS);
        Assert.assertEquals("Twos should score 0", 0, points);

        diceList = TestUtils.createReversedFullHouseTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.THREES);
        Assert.assertEquals("Threes should score 9", 9, points);

        diceList = TestUtils.createHeadingFourTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FOURS);
        Assert.assertEquals("Fours should score 16", 16, points);

        diceList = TestUtils.createFullHouseTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.FIVES);
        Assert.assertEquals("Fives should score 10", 10, points);

        diceList = TestUtils.createTrailingFourTestCase();
        points = ScoreHelper.calculatePoints(diceList, GameCategory.SIXES);
        Assert.assertEquals("Sixes should score 24", 24, points);
    }
}
