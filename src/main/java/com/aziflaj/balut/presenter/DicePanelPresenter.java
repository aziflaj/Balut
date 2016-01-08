package com.aziflaj.balut.presenter;


import com.aziflaj.balut.model.Dice;

import java.util.ArrayList;

public interface DicePanelPresenter {
    /**
     * @return the dice list of the Presenter implementation
     */
    ArrayList<Dice> getDiceList();

    /**
     * Rolls all the dices
     */
    void rollAllDices();

    /**
     * Returns a dice at the given index
     *
     * @param index The index of the dice to return
     * @return The dice at the given index
     */
    Dice getDiceAt(int index);
}
