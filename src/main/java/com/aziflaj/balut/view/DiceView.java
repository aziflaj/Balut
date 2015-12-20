package com.aziflaj.balut.view;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.utils.ResourceHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class DiceView extends JButton implements ActionListener, DiceMvpView {
    Dice mDice;

    public DiceView(Dice dice) {
        mDice = dice;

        repaintView();

        // make the background transparent
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.addActionListener(this);
    }

    public void repaintView() {
        if (mDice.getState() == Dice.SELECTED) {
            URL selectedView = ResourceHelper.getSelectedDice(mDice.getValue());
            this.setIcon(new ImageIcon(selectedView));
        } else if (mDice.getState() == Dice.UNSELECTED) {
            URL selectedView = ResourceHelper.getUnselectedDice(mDice.getValue());
            this.setIcon(new ImageIcon(selectedView));
        } else {
            URL questionMarkUrl = ResourceHelper.getResourceURL("dices/question_dice.png");
            this.setIcon(new ImageIcon(questionMarkUrl));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (mDice.getState() == Dice.SELECTED) {
            URL selectedView = ResourceHelper.getUnselectedDice(mDice.getValue());
            this.setIcon(new ImageIcon(selectedView));
            mDice.unSelect();
        } else if (mDice.getState() == Dice.UNSELECTED) {
            URL selectedView = ResourceHelper.getSelectedDice(mDice.getValue());
            this.setIcon(new ImageIcon(selectedView));
            mDice.select();
        }
    }

    @Override
    public void updateDice(Dice dice) {
        this.mDice = dice;
        repaintView();
    }
}
