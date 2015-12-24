package com.aziflaj.balut.view;


import com.aziflaj.balut.presenter.PlayerPresenter;
import com.aziflaj.balut.view.dice.DicePanel;
import com.aziflaj.balut.view.player.CategoriesPanel;
import com.aziflaj.balut.view.player.PlayerPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code JFrame} that will contain all the views
 */
public class MainView extends JFrame {
    public static final String STATUS_FORMAT = "%s turn.";
    JLabel statusLabel;
    ArrayList<PlayerPresenter> presenters;
    DicePanel mDicePanel;

    /**
     * Creates a UI frame, putting every UI widget in its place
     */
    public MainView(List<String> players) {
        super("Balut");
        statusLabel = new JLabel("Hello");

        JPanel containerPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        containerPanel.setBorder(BorderFactory.createEtchedBorder());
        mDicePanel = new DicePanel();
        containerPanel.add(mDicePanel);
        containerPanel.add(new CategoriesPanel());
        PlayerPanel playerPanel = new PlayerPanel(players);
        containerPanel.add(playerPanel);
        containerPanel.setOpaque(false);

        presenters = playerPanel.getPresenters();

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

    public ArrayList<PlayerPresenter> getPresenters() {
        return presenters;
    }

    public void enableRolling() {
        mDicePanel.enableRolling();
    }
}
