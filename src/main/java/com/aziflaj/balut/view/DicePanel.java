package com.aziflaj.balut.view;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.presenter.DicePanelPresenter;
import com.aziflaj.balut.presenter.DicePanelPresenterImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DicePanel extends JPanel {
    DicePanelPresenter mPresenter;
    JButton rollDicesBtn;
    ArrayList<DiceView> diceViewArrayList;

    public DicePanel() {
        mPresenter = new DicePanelPresenterImpl();

        rollDicesBtn = new JButton("Roll the dice");
        diceViewArrayList = new ArrayList<>();

        for (Dice d : mPresenter.getDiceList()) {
            DiceView diceView = new DiceView(d);
            diceViewArrayList.add(diceView);
        }

        // set the layout as vertical
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(rollDicesBtn);
        for (DiceView dv : diceViewArrayList) {
            this.add(dv);
        }

        rollDicesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rollDices();
            }
        });
    }

    private void rollDices() {
        mPresenter.rollAllDices();
        int i = 0;
        for (DiceView dv : diceViewArrayList) {
            dv.updateDice(mPresenter.getDiceAt(i));
        }
    }
}
