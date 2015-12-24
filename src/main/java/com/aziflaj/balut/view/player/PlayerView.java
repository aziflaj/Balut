package com.aziflaj.balut.view.player;

import com.aziflaj.balut.presenter.PlayerPresenter;
import com.aziflaj.balut.presenter.PlayerPresenterImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PlayerView extends JPanel {
    private static final String SCORE_FORMAT = "   %02d   ";

    JLabel playerNameLabel;
    PlayerPresenter mPresenter;
    ArrayList<JButton> buttonList;

    public PlayerView(String name) {
        mPresenter = new PlayerPresenterImpl(name);

        // start putting the UI in place
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        playerNameLabel = new JLabel(name);
        this.add(playerNameLabel);
        playerNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonList = new ArrayList<>();
        // create the points list
        for (int i = 0; i < 17; i++) {
            final JButton button = new JButton(String.format(SCORE_FORMAT, 0));
            this.add(button);
            buttonList.add(button);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            if (i == 6 || i == 7 || i == 15 || i == 16) {
                button.setEnabled(false);
            } else {
                final int index = i;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        System.out.println("Button clicked");
                        int points = mPresenter.calculatePoints(index);
                        System.out.println("Points: " + points);

                        button.setText(String.format(SCORE_FORMAT, points));
                        button.setEnabled(false);
                    }
                });
            }
        }
    }

    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }
}
