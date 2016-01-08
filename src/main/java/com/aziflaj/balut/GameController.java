package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.model.Player;
import com.aziflaj.balut.presenter.PlayerPresenter;
import com.aziflaj.balut.utils.db.DatabaseOpenHelper;
import com.aziflaj.balut.view.MainView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static GameController instance = null;

    List<Dice> mDiceList = null;
    List<PlayerPresenter> mPlayerPresenters;
    int playersNumber = 0;
    List<String> playerNames;
    List<Player> playerList;
    int playerIndex = 0;
    int turnCounter = 0;
    MainView gameView;

    /**
     * Create a Game Controller for the game to be played
     */
    private GameController() throws SQLException {
        playerNames = new ArrayList<>();
        playerList = new ArrayList<>();

        for (String name : playerNames) {
            playerList.add(new Player(name));
        }

        // get the number of players
        while (playersNumber < 5 || playersNumber > 0) {
            String playersNumberStr = JOptionPane.showInputDialog(
                    null,
                    "Set the number of players",
                    "Players",
                    JOptionPane.QUESTION_MESSAGE);

            playersNumber = Integer.parseInt(playersNumberStr);

            if (playersNumber > 4 || playersNumber < 1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Only numbers 1 to 4 are allowed!",
                        "Players",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                break;
            }
        }

        for (int i = 0; i < playersNumber; i++) {
            // TODO: check the new user in the DB. if not exists, create
            String playerName;
            do {
                playerName = JOptionPane.showInputDialog(
                        null,
                        String.format("Enter Player's %d name", (i + 1)),
                        "Players",
                        JOptionPane.QUESTION_MESSAGE);

                if (playerName.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Player's name shouldn't be empty!",
                            "Players",
                            JOptionPane.ERROR_MESSAGE);
                }
            } while (playerName.isEmpty());
            playerNames.add(playerName);
            playerList.add(new Player(playerName));
        }

        gameView = new MainView(playerNames);
        mPlayerPresenters = gameView.getPresenters();
        gameView.run();

        playTurn();
    }

    /**
     * @return The instance of the GameController singleton
     */
    public static GameController getInstance() throws SQLException {
        if (instance == null) {
            instance = new GameController();
        }

        return instance;
    }

    /**
     * Create the instance if it is not already created, and start the game
     */
    public static void start() throws SQLException {
        GameController.getInstance();
    }

    /**
     * Roll all of the dice in the game
     *
     * @param diceList The dice list
     * @return The list of new dice
     */
    public ArrayList<Dice> rollDice(ArrayList<Dice> diceList) {
        for (Dice dice : diceList) {
            dice.roll();
        }
        mDiceList = diceList;
        return diceList;
    }

    /**
     * Roll some of the dice in the given {@code diceList}
     *
     * @param diceList The list of all dice in the game
     * @param indices  The indices of the dice to roll
     * @return The list of new dice
     */
    public ArrayList<Dice> rollSomeDice(ArrayList<Dice> diceList, int[] indices) {
        for (int i : indices) {
            diceList.get(i).roll();
        }
        mDiceList = diceList;
        return diceList;
    }

    /**
     * @return The next player who should play
     */
    private Player nextPlayer() {
        if (playerIndex >= playerList.size()) {
            playerIndex = 0;
            turnCounter++;
        }

        return playerList.get(playerIndex++);
    }

    /**
     * Play the turn of each player
     */
    public void playTurn() throws SQLException {
        Player player = nextPlayer();
        int index = 0;
        for (PlayerPresenter p : mPlayerPresenters) {
            if (index == playerIndex - 1) {
                p.getView().enableView();
            } else {
                p.getView().disableView();
            }
            index++;
        }

        // TODO: save score in sqlite
        if (turnCounter >= 13) {
            gameView.setStatus("Game finished!");
            Player winner = getWinner(mPlayerPresenters);
            int max = winner.getPoints();
            JOptionPane.showMessageDialog(
                    null,
                    "High Score: " + max + " by " + winner.getName(),
                    "Game Finished",
                    JOptionPane.INFORMATION_MESSAGE);
            DatabaseOpenHelper.getInstance().addNewScore(winner.getName(), max);
            return;
        } else {
            System.out.println("Turn: " + turnCounter);
        }

        gameView.setStatus(String.format(MainView.STATUS_FORMAT, player.getName()));

        if (mPlayerPresenters != null) {
            for (PlayerPresenter presenter : mPlayerPresenters) {
                int upper = presenter.calculateUpperPoints();
                presenter.getView()
                        .updateButton(6, upper)
                        .updateButton(15, presenter.calculateLowerPoints())
                        .updateButton(16, presenter.calculateTotal());

                if (upper > 63) {
                    presenter.getView().updateButton(7, 35);
                }
            }
        }
    }

    /**
     * Get the winner of the game
     *
     * @param mPlayerPresenters The Player presenters, from where the winner
     *                          will be found
     * @return The winner of the game
     */
    private Player getWinner(List<PlayerPresenter> mPlayerPresenters) {
        Player winner = mPlayerPresenters.get(0).getPlayer();
        for (int i = 1; i < mPlayerPresenters.size(); i++) {
            if (winner.getPoints() < mPlayerPresenters.get(i).getPlayer().getPoints()) {
                winner = mPlayerPresenters.get(i).getPlayer();
            }
        }
        return winner;
    }

    /**
     * @return The list of all dice in the game
     */
    public List<Dice> getDiceList() {
        return mDiceList;
    }

    /**
     * Enables rolling of the dice so the game can go on
     */
    public void enableRolling() {
        gameView.enableRolling();
    }
}
