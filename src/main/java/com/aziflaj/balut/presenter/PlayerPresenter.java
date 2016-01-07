package com.aziflaj.balut.presenter;

import com.aziflaj.balut.model.Player;
import com.aziflaj.balut.utils.GameCategory;
import com.aziflaj.balut.view.player.PlayerView;

public interface PlayerPresenter {
    /**
     * Add points to a player in the given category
     *
     * @param gameCategory A {@code GameCategory} enum object, representing the
     *                     category of the game
     * @param points       The score to add to the player
     */
    void addPoints(GameCategory gameCategory, int points);

    /**
     * @return The score of the six first categories
     */
    int calculateUpperPoints();

    /**
     * @return The score of the categories not calculated by the
     * {@code calculateUpperPoints()} method
     */
    int calculateLowerPoints();

    /**
     * @return The total score
     */
    int calculateTotal();

    /**
     * @return The view corresponding to the presenter
     */
    PlayerView getView();

    /**
     * @return The player corresponding to the presenter
     */
    Player getPlayer();

    /**
     * Calculate the score of each roll
     *
     * @param index The index representing the game category
     * @return The score for the given category
     */
    int calculatePoints(int index);
}
