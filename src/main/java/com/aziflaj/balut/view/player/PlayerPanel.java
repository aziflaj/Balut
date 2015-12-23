package com.aziflaj.balut.view.player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    public PlayerPanel(int players) {
        this.setLayout(new GridLayout());

        for (int i = 0; i < players; i++) {
            PlayerView player = new PlayerView("Player" + (i + 1));
            this.add(player);
        }

    }
}
