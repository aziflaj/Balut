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

    public DicePanel() {
        mPresenter = new DicePanelPresenterImpl();
        rollDicesBtn = new JButton("Roll the dice");

        rollDicesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rollDices();
            }
        });

        // set the layout as vertical
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(rollDicesBtn);
        ArrayList<Dice> diceList = mPresenter.getDiceList();
        for (Dice d : diceList) {
            DiceView diceView = new DiceView(d);
            this.add(diceView);
        }
    }

    private void rollDices() {
        System.out.println("Rolling dices");
    }


}
