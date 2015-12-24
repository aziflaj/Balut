package com.aziflaj.balut.view.player;

import com.aziflaj.balut.GameController;
import com.aziflaj.balut.presenter.PlayerPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerPanel extends JPanel {

    public PlayerPanel(List<String> players) {
        this.setLayout(new GridLayout());
        ArrayList<PlayerPresenter> presenters = new ArrayList<>();
        for (String playerName : players) {
            PlayerView player = new PlayerView(playerName);
            presenters.add(player.mPresenter);
            this.add(player);
        }
//        GameController.getInstance().setPlayerPresenters(presenters);
    }
}
