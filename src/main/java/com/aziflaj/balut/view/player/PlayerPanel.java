package com.aziflaj.balut.view.player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlayerPanel extends JPanel {

    public PlayerPanel(List<String> players) {
        this.setLayout(new GridLayout());

        for (String playerName : players) {
            PlayerView player = new PlayerView(playerName);
            this.add(player);
        }
    }
}
