package com.aziflaj.balut.view.player;

import com.aziflaj.balut.presenter.PlayerPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerPanel extends JPanel {

    ArrayList<PlayerPresenter> presenters;
    ArrayList<PlayerView> views;

    /**
     * Creates the Players panel with all the Player views
     *
     * @param players A list of names of the players
     */
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

    /**
     * @return The list of all the player presenters
     */
    public ArrayList<PlayerPresenter> getPresenters() {
        return presenters;
    }
}
