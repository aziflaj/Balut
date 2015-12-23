package com.aziflaj.balut.view;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {

    public PlayerPanel() {
        this.setLayout(new GridLayout());

        PlayerView onePlayer = new PlayerView("Aldo");
        PlayerView anotherPlayer = new PlayerView("Bond");

        this.add(onePlayer);
        this.add(anotherPlayer);
    }
}
