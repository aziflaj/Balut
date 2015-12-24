package com.aziflaj.balut.presenter;

import com.aziflaj.balut.GameController;
import com.aziflaj.balut.model.Player;
import com.aziflaj.balut.utils.GameCategory;
import com.aziflaj.balut.utils.ScoreHelper;

import java.util.HashMap;
import java.util.Map;

public class PlayerPresenterImpl implements PlayerPresenter {
    Player mPlayer;
    Map<GameCategory, Integer> mPointsMap;

    public PlayerPresenterImpl(String name) {
        mPlayer = new Player(name);
        mPointsMap = new HashMap<>();

        // upper points
        mPointsMap.put(GameCategory.ONES, null);
        mPointsMap.put(GameCategory.TWOS, null);
        mPointsMap.put(GameCategory.THREES, null);
        mPointsMap.put(GameCategory.FOURS, null);
        mPointsMap.put(GameCategory.FIVES, null);
        mPointsMap.put(GameCategory.SIXES, null);

        // lower points
        mPointsMap.put(GameCategory.THREE_OF_A_KIND, null);
        mPointsMap.put(GameCategory.FOUR_OF_A_KIND, null);
        mPointsMap.put(GameCategory.FULL_HOUSE, null);
        mPointsMap.put(GameCategory.FOUR_STAIR, null);
        mPointsMap.put(GameCategory.FIVE_STAIR, null);
        mPointsMap.put(GameCategory.FIVE_OF_A_KIND, null);
        mPointsMap.put(GameCategory.ANY_CASE, null);
    }

    @Override
    public void play() {
        rollDices();
    }

    @Override
    public void addPoints(GameCategory gameCategory) {

    }

    @Override
    public int calculateUpperPoints() {
        return mPointsMap.get(GameCategory.ONES)
                + mPointsMap.get(GameCategory.TWOS)
                + mPointsMap.get(GameCategory.THREES)
                + mPointsMap.get(GameCategory.FOURS)
                + mPointsMap.get(GameCategory.FIVES)
                + mPointsMap.get(GameCategory.SIXES);
    }

    @Override
    public int calculateLowerPoints() {
        return mPointsMap.get(GameCategory.THREE_OF_A_KIND)
                + mPointsMap.get(GameCategory.FOUR_OF_A_KIND)
                + mPointsMap.get(GameCategory.FULL_HOUSE)
                + mPointsMap.get(GameCategory.FOUR_STAIR)
                + mPointsMap.get(GameCategory.FIVE_STAIR)
                + mPointsMap.get(GameCategory.FIVE_OF_A_KIND)
                + mPointsMap.get(GameCategory.ANY_CASE);
    }

    @Override
    public int calculateTotal() {
        int lower = calculateLowerPoints();
        int bonus = (lower > 63) ? 35 : 0;
        int upper = calculateUpperPoints();
        return lower + bonus + upper;
    }

    private void rollDices() {
        System.out.println("Rolling dices");
    }

    public int calculatePoints(int index) {
        switch (index) {
            case 0: // ONES
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.ONES);

            case 1: // TWOS
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.TWOS);

            case 2: // THREES
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.THREES);

            case 3: // FOURS
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FOURS);

            case 4: // FIVES
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FIVES);

            case 5: // SIXES
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.SIXES);

            case 8: // THREE OF A KIND
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.THREE_OF_A_KIND);

            case 9: // FOUR OF A KIND
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FOUR_OF_A_KIND);

            case 10: // FULL HOUSE
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FULL_HOUSE);

            case 11: // FOUR STAIR
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FOUR_STAIR);

            case 12: // FIVE STAIR
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FIVE_STAIR);

            case 13: // FIVE OF A KIND
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FIVE_OF_A_KIND);

            case 14: // ANY CASE
                return ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.ANY_CASE);

            default:
                return 0;
        }
    }
}
