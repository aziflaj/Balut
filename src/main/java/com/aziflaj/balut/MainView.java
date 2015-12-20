package com.aziflaj.balut;


import com.aziflaj.balut.view.DicePanel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public MainView() {
        super("Balut");

        this.setLayout(new GridLayout(1, 3, 10, 10));
        this.add(new DicePanel());
    }

    public void run() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null); // center on screen
        this.setResizable(false);
        this.setVisible(true);
    }
}
