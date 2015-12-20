package com.aziflaj.balut;


import com.aziflaj.balut.view.DicePanel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public MainView() {
        super("Balut");
        System.out.println("Calling MainView");

        this.setLayout(new GridLayout(1, 3, 10, 10));
        this.add(new DicePanel());
    }

    public void run() {
        System.out.println("Running MainView instance");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}
