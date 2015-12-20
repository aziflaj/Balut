package com.aziflaj.balut.presenter;

import com.aziflaj.balut.model.Dice;

import java.util.ArrayList;
import java.util.Random;

public class DicePanelPresenterImpl implements DicePanelPresenter {
    ArrayList<Dice> diceList;

    public DicePanelPresenterImpl() {
        diceList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Dice dice = new Dice();
            //TODO: debugging only! remove!
            dice.roll();
            diceList.add(dice);
        }
    }

    @Override
    public ArrayList<Dice> getDiceList() {
        return diceList;
    }

    @Override
    public void throwDices(int[] indices) {
        Random rnd = new Random();
        // TODO: Implement
    }

    @Override
    public void rollAllDices() {
        for (Dice dice : diceList) {
            dice.roll();
        }
    }

    @Override
    public Dice getDiceAt(int i) {
        return diceList.get(i);
    }
}
