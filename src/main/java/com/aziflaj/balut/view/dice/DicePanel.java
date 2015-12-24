package com.aziflaj.balut.view.dice;

import com.aziflaj.balut.GameController;
import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.presenter.DicePanelPresenter;
import com.aziflaj.balut.presenter.DicePanelPresenterImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DicePanel extends JPanel {
    DicePanelPresenter mPresenter;
    JButton mRollDicesBtn;
    ArrayList<DiceView> mDiceViewList;

    public DicePanel() {
        mPresenter = new DicePanelPresenterImpl();

        mRollDicesBtn = new JButton("Roll the dice");
        mRollDicesBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        mRollDicesBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        mRollDicesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rollDices();
//                GameController.getInstance().playTurn();
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

    private void rollDices() {
        mPresenter.rollAllDices();
        int i = 0;
        for (DiceView dv : mDiceViewList) {
            dv.updateDice(mPresenter.getDiceAt(i++));
        }
    }
}
