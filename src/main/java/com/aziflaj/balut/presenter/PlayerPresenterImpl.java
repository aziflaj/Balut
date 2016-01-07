package com.aziflaj.balut.presenter;

import com.aziflaj.balut.GameController;
import com.aziflaj.balut.model.Player;
import com.aziflaj.balut.utils.GameCategory;
import com.aziflaj.balut.utils.ScoreHelper;
import com.aziflaj.balut.view.player.PlayerView;

import java.util.HashMap;
import java.util.Map;

public class PlayerPresenterImpl implements PlayerPresenter {
    Player player;
    private Map<GameCategory, Integer> mPointsMap;
    private PlayerView mView;

    /**
     * Creates an implementation instance of the {@code PlayerPresenter},
     * with all scores as 0
     *
     * @param name The name of the player
     * @param view The view corresponding to the presenter
     */
    public PlayerPresenterImpl(String name, PlayerView view) {
        player = new Player(name);
        mView = view;
        mPointsMap = new HashMap<>();

        // upper points
        mPointsMap.put(GameCategory.ONES, 0);
        mPointsMap.put(GameCategory.TWOS, 0);
        mPointsMap.put(GameCategory.THREES, 0);
        mPointsMap.put(GameCategory.FOURS, 0);
        mPointsMap.put(GameCategory.FIVES, 0);
        mPointsMap.put(GameCategory.SIXES, 0);

        // lower points
        mPointsMap.put(GameCategory.THREE_OF_A_KIND, 0);
        mPointsMap.put(GameCategory.FOUR_OF_A_KIND, 0);
        mPointsMap.put(GameCategory.FULL_HOUSE, 0);
        mPointsMap.put(GameCategory.FOUR_STAIR, 0);
        mPointsMap.put(GameCategory.FIVE_STAIR, 0);
        mPointsMap.put(GameCategory.FIVE_OF_A_KIND, 0);
        mPointsMap.put(GameCategory.ANY_CASE, 0);
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void addPoints(GameCategory gameCategory, int points) {
        player.addPoints(points);
        mPointsMap.put(gameCategory, points);
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

    @Override
    public PlayerView getView() {
        return mView;
    }

    @Override
    public int calculatePoints(int index) {
        int points;
        switch (index) {
            case 0: // ONES
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.ONES);
                addPoints(GameCategory.ONES, points);
                return points;

            case 1: // TWOS
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.TWOS);
                addPoints(GameCategory.TWOS, points);
                return points;

            case 2: // THREES
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.THREES);
                addPoints(GameCategory.THREES, points);
                return points;

            case 3: // FOURS
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FOURS);
                addPoints(GameCategory.FOURS, points);
                return points;

            case 4: // FIVES
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FIVES);
                addPoints(GameCategory.FIVES, points);
                return points;

            case 5: // SIXES
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.SIXES);
                addPoints(GameCategory.SIXES, points);
                return points;

            case 8: // THREE OF A KIND
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.THREE_OF_A_KIND);
                addPoints(GameCategory.THREE_OF_A_KIND, points);
                return points;

            case 9: // FOUR OF A KIND
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FOUR_OF_A_KIND);
                addPoints(GameCategory.FOUR_OF_A_KIND, points);
                return points;

            case 10: // FULL HOUSE
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FULL_HOUSE);
                addPoints(GameCategory.FULL_HOUSE, points);
                return points;

            case 11: // FOUR STAIR
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FOUR_STAIR);
                addPoints(GameCategory.FOUR_STAIR, points);
                return points;

            case 12: // FIVE STAIR
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FIVE_STAIR);
                addPoints(GameCategory.FIVE_STAIR, points);
                return points;

            case 13: // FIVE OF A KIND
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.FIVE_OF_A_KIND);
                addPoints(GameCategory.FIVE_OF_A_KIND, points);
                return points;

            case 14: // ANY CASE
                points = ScoreHelper.calculatePoints(
                        GameController.getInstance().getDiceList(),
                        GameCategory.ANY_CASE);
                addPoints(GameCategory.ANY_CASE, points);
                return points;

            default:
                return 0;
        }
    }
}
