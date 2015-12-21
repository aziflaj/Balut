package com.aziflaj.balut.view;


import com.aziflaj.balut.view.DicePanel;

import javax.swing.*;
import java.awt.*;

/**
 * The {@code JFrame} that will contain all the views
 */
public class MainView extends JFrame {

    /**
     * Creates a UI frame, putting every UI widget in its place
     */
    public MainView() {
        super("Balut");

        JPanel containerPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        containerPanel.setBorder(BorderFactory.createEtchedBorder());
        containerPanel.add(new DicePanel());
        containerPanel.setOpaque(false);

        this.setBackground(Color.GREEN);
//        this.setLayout(new GridLayout(1, 3, 10, 10));
//        this.add(new DicePanel());
        this.add(containerPanel);
    }

    /**
     * Shows the frame in the screen
     */
    public void run() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null); // center on screen
        this.setResizable(false);
        this.setVisible(true);
    }
}
