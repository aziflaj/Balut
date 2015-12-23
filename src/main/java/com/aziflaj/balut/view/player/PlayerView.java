package com.aziflaj.balut.view.player;

import com.aziflaj.balut.presenter.PlayerPresenter;
import com.aziflaj.balut.presenter.PlayerPresenterImpl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayerView extends JPanel {
    JLabel playerNameLabel;
    PlayerPresenter mPresenter;
    ArrayList<JLabel> pointsList;

    private static final String SCORE_FORMAT = "   %02d   ";

    public PlayerView(String name) {
        mPresenter = new PlayerPresenterImpl(name);

        // start putting the UI in place
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        playerNameLabel = new JLabel(name);
        this.add(playerNameLabel);
        playerNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        pointsList = new ArrayList<>();
        // create the points list
        for (int i = 0; i < 17; i++) {
            JButton button = new JButton(String.format(SCORE_FORMAT, 0));
            this.add(button);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
    }
}
