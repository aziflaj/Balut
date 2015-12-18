package com.aziflaj.balut.presenter;

import com.aziflaj.balut.utils.ResourceHelper;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DicePanelPresenterImpl implements DicePanelPresenter {
    private final String[] DICE_FACES = {
            "face_one.png",
            "face_two.png",
            "face_three.png",
            "face_four.png",
            "face_five.png",
            "face_six.png"
    };

    ArrayList<JButton> dices;

    public DicePanelPresenterImpl() {
        dices = new ArrayList<>();
        URL questionDiceImage = ResourceHelper.getResourceURL("question_dice.png");

        for (int i = 0; i < 5; i++) {
            // TODO: Turn this JButton into a Dice class with all the attributes
            JButton button = new JButton(new ImageIcon(questionDiceImage));
            dices.add(button);
        }
    }

    @Override
    public List<JButton> getDiceList() {
        return dices;
    }

    @Override
    public void throwDices(int[] indices) {

    }

    @Override
    public void throwAllDices() {
        Random rnd = new Random();
        for (JButton dice : dices) {
            int roll = rnd.nextInt(6);
            System.out.println("Rolled " + roll);
            URL diceFaceUrl = ResourceHelper.getResourceURL("dices/unselected/" + DICE_FACES[roll]);
            dice.setIcon(new ImageIcon(diceFaceUrl));
        }
    }
}
