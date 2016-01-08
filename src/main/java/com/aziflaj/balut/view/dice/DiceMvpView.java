package com.aziflaj.balut.view.dice;

import com.aziflaj.balut.model.Dice;

/**
 * The MVP view interface, painting the Dice view in the UI
 */
public interface DiceMvpView {

    /**
     * Updates the dice when the dice is rolled again
     *
     * @param dice The new dice, which should replace the older one
     */
    void updateDice(Dice dice);
}
