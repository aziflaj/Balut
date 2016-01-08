package com.aziflaj.balut.view.player;

import com.aziflaj.balut.GameController;
import com.aziflaj.balut.presenter.PlayerPresenter;
import com.aziflaj.balut.presenter.PlayerPresenterImpl;
import com.aziflaj.balut.utils.BalutExceptionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayerView extends JPanel {
    private static final String SCORE_FORMAT = "   %03d   ";

    JLabel playerNameLabel;
    PlayerPresenter mPresenter;
    ArrayList<JButton> buttonList;

    public PlayerView(String name) {
        mPresenter = new PlayerPresenterImpl(name, this);

        // start putting the UI in place
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        playerNameLabel = new JLabel(name);
        this.add(playerNameLabel);
        playerNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonList = new ArrayList<>();
        // create the points list
        for (int i = 0; i < 17; i++) {
            final JButton button = new JButton(String.format(SCORE_FORMAT, 0));
            this.add(button);
            buttonList.add(button);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            if (i == 6 || i == 7 || i == 15 || i == 16) {
                button.setEnabled(false);
            } else {
                final int index = i;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int points = mPresenter.calculatePoints(index);

                        button.setText(String.format(SCORE_FORMAT, points));
                        button.setEnabled(false);
                        try {
                            GameController.getInstance().enableRolling();
                            GameController.getInstance().playTurn();
                        } catch (SQLException e) {
                            e.printStackTrace();
                            BalutExceptionHandler.handleException(e);
                        }
                    }
                });
            }
        }
    }

    /**
     * Updates the score on the button view
     *
     * @param i     The index of the button
     * @param score The score to show
     * @return The {@code PlayerView} instance calling the method, for chaining
     * cases
     */
    public PlayerView updateButton(int i, int score) {
        buttonList.get(i).setText(String.format(SCORE_FORMAT, score));
        return this;
    }

    /**
     * Disable the view so other players don't play for this player
     */
    public void disableView() {
        for (JButton b : buttonList) {
            b.setEnabled(false);
        }
    }

    /**
     * Enables the view for the player to play
     */
    public void enableView() {
        for (JButton b : buttonList) {
            b.setEnabled(true);
        }
    }
}
