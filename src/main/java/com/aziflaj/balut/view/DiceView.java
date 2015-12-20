package com.aziflaj.balut.view;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.utils.ResourceHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class DiceView extends JButton implements ActionListener {
    Dice mDice;

    public DiceView(Dice dice) {
        mDice = dice;

        URL questionMark = ResourceHelper.getResourceURL("dices/question_dice.png");
        this.setIcon(new ImageIcon(questionMark));

        // make the background transparent
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (mDice.getState() == Dice.SELECTED) {
            URL selectedView = ResourceHelper.getUnselectedDice(mDice.getValue());
            this.setIcon(new ImageIcon(selectedView));
            mDice.unSelect();
        } else {
            URL selectedView = ResourceHelper.getSelectedDice(mDice.getValue());
            this.setIcon(new ImageIcon(selectedView));
            mDice.select();
        }
    }
}
