package com.aziflaj.balut.presenter;

import com.aziflaj.balut.model.Dice;

import java.util.ArrayList;
import java.util.Random;

public class DicePanelPresenterImpl implements DicePanelPresenter {
    // TODO: move to the Dice model
    private final String[] DICE_FACES = {
            "face_one.png",
            "face_two.png",
            "face_three.png",
            "face_four.png",
            "face_five.png",
            "face_six.png"
    };

    ArrayList<Dice> diceList;

    public DicePanelPresenterImpl() {
        diceList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Dice dice = new Dice();
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
}
