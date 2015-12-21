package com.aziflaj.balut.presenter;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.utils.ResultHelper;

import java.util.ArrayList;

/**
 * The implementation of {@code DicePanelPresenter}, holding the functionality of the Presenter
 */
public class DicePanelPresenterImpl implements DicePanelPresenter {
    ArrayList<Dice> mDiceList;

    /**
     * Create the list of the dice used by the game (5 dice)
     */
    public DicePanelPresenterImpl() {
        mDiceList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Dice dice = new Dice();
            mDiceList.add(dice);
        }
    }

    @Override
    public ArrayList<Dice> getDiceList() {
        return mDiceList;
    }

    @Override
    public void rollDices(int[] indices) {
        for (int i : indices) {
            mDiceList.get(i).roll();
        }
    }

    @Override
    public void rollAllDices() {
        for (Dice dice : mDiceList) {
            dice.roll();
        }
        int points = ResultHelper.calculatePoints(mDiceList);
        System.out.println("Result: " + points);
    }

    @Override
    public Dice getDiceAt(int i) {
        return mDiceList.get(i);
    }
}
