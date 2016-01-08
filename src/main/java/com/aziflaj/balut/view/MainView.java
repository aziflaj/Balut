package com.aziflaj.balut.view;


import com.aziflaj.balut.model.Player;
import com.aziflaj.balut.presenter.PlayerPresenter;
import com.aziflaj.balut.utils.BalutExceptionHandler;
import com.aziflaj.balut.utils.db.DatabaseOpenHelper;
import com.aziflaj.balut.view.dice.DicePanel;
import com.aziflaj.balut.view.player.CategoriesPanel;
import com.aziflaj.balut.view.player.PlayerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code JFrame} that will contain all the views
 */
public class MainView extends JFrame implements ActionListener {
    public static final String STATUS_FORMAT = "%s turn.";
    JLabel statusLabel;
    ArrayList<PlayerPresenter> presenters;
    DicePanel mDicePanel;

    JMenuItem recordMenu;
    JMenuItem aboutMenu;

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

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        recordMenu = new JMenuItem("Record");
        menuBar.add(recordMenu);
        aboutMenu = new JMenuItem("About");
        menuBar.add(aboutMenu);
        recordMenu.addActionListener(this);
        aboutMenu.addActionListener(this);

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

    /**
     * Change the status of the game
     *
     * @param status The status of the game
     */
    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    /**
     * @return All the {@code PlayerPresenter}s of the game
     */
    public ArrayList<PlayerPresenter> getPresenters() {
        return presenters;
    }

    /**
     * Enables rolling for the game to go on
     */
    public void enableRolling() {
        mDicePanel.enableRolling();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == recordMenu) {
            try {
                Player winner = DatabaseOpenHelper.getInstance().getRecordman();
                JOptionPane.showMessageDialog(
                        null,
                        String.format("The record is %d by %s", winner.getPoints(), winner.getName()),
                        "Record",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
                BalutExceptionHandler.handleException(e);
            }
        } else if (ae.getSource() == aboutMenu) {
            JOptionPane.showMessageDialog(
                    null,
                    "This app is developed by Aldo Ziflaj",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
