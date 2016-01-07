package com.aziflaj.balut.view.player;

import com.aziflaj.balut.presenter.PlayerPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerPanel extends JPanel {

    ArrayList<PlayerPresenter> presenters;
    ArrayList<PlayerView> views;

    public PlayerPanel(List<String> players) {
        this.setLayout(new GridLayout());
        presenters = new ArrayList<>();
        views = new ArrayList<>();
        for (String playerName : players) {
            PlayerView player = new PlayerView(playerName);
            presenters.add(player.mPresenter);
            views.add(player);
            this.add(player);
        }
    }

    public ArrayList<PlayerPresenter> getPresenters() {
        return presenters;
    }

    public void enableOnly(int index) {
        int i = 0;
        for (PlayerView v : views) {
            if (i == index) {
                v.enableView();
            } else {
                v.disableView();
            }
        }
    }
}
