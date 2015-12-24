package com.aziflaj.balut.view.player;

import com.aziflaj.balut.presenter.PlayerPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerPanel extends JPanel {

    ArrayList<PlayerPresenter> presenters;

    public PlayerPanel(List<String> players) {
        this.setLayout(new GridLayout());
        presenters = new ArrayList<>();
        for (String playerName : players) {
            PlayerView player = new PlayerView(playerName);
            presenters.add(player.mPresenter);
            this.add(player);
        }
    }

    public ArrayList<PlayerPresenter> getPresenters() {
        return presenters;
    }
}
