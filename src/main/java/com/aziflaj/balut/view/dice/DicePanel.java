package com.aziflaj.balut.view.dice;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.presenter.DicePanelPresenter;
import com.aziflaj.balut.presenter.DicePanelPresenterImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * A JPanel class that holds the dice of the game
 */
public class DicePanel extends JPanel {
    DicePanelPresenter mPresenter;
    JButton mRollDicesBtn;
    ArrayList<DiceView> mDiceViewList;

    int clicked = 0;

    /**
     * Creates the panel
     */
    public DicePanel() {
        mPresenter = new DicePanelPresenterImpl();

        mRollDicesBtn = new JButton("Roll the dice");
        mRollDicesBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        mRollDicesBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        mRollDicesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (clicked < 3) {
                    rollDices();
                    clicked++;
                } else {
                    clicked = 0;
                    mRollDicesBtn.setEnabled(false); // so the scoring button will be clicked
                }
            }
        });

        mDiceViewList = new ArrayList<>();
        for (Dice d : mPresenter.getDiceList()) {
            DiceView diceView = new DiceView(d);
            mDiceViewList.add(diceView);
        }

        // set the layout as vertical
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(mRollDicesBtn);
        for (DiceView dv : mDiceViewList) {
            this.add(dv);
            dv.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        this.setOpaque(false);
    }

    /**
     * Calls the {@code rollAllDices} method from its presenter and updates all the
     * {@code DiceView}s
     */
    private void rollDices() {
        mPresenter.rollAllDices();
        int i = 0;
        for (DiceView dv : mDiceViewList) {
            dv.updateDice(mPresenter.getDiceAt(i++));
        }
    }

    /**
     * Allows the player to roll the dice to play
     */
    public void enableRolling() {
        mRollDicesBtn.setEnabled(true);
        clicked = 0;
    }
}
