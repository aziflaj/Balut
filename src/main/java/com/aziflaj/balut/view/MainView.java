package com.aziflaj.balut.view;


import com.aziflaj.balut.view.dice.DicePanel;
import com.aziflaj.balut.view.player.CategoriesPanel;
import com.aziflaj.balut.view.player.PlayerPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * The {@code JFrame} that will contain all the views
 */
public class MainView extends JFrame {
    JLabel statusLabel;

    /**
     * Creates a UI frame, putting every UI widget in its place
     */
    public MainView(List<String> players) {
        super("Balut");
        statusLabel = new JLabel("Hello My People");

        JPanel containerPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        containerPanel.setBorder(BorderFactory.createEtchedBorder());
        containerPanel.add(new DicePanel());
        containerPanel.add(new CategoriesPanel());
        containerPanel.add(new PlayerPanel(players));
        containerPanel.setOpaque(false);

        this.setLayout(new BorderLayout());
        this.add(containerPanel, BorderLayout.CENTER);
        this.add(statusLabel, BorderLayout.SOUTH);
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

    public void setStatus(String status) {
        statusLabel.setText(status);
    }
}
