package com.aziflaj.balut.presenter;

import com.aziflaj.balut.model.Player;
import com.aziflaj.balut.utils.GameCategory;

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
    public void rollDice() {

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
}
