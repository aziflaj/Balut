package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.model.Player;
import com.aziflaj.balut.presenter.PlayerPresenter;
import com.aziflaj.balut.view.MainView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static GameController instance = null;

    List<Dice> mDiceList = null;
    List<PlayerPresenter> mPlayerPresenters;
    int rolls = 0;
    int playersNumber = 0;
    List<String> playerNames;
    List<Player> playerList;
    int playerIndex = 0;
    MainView gameView;

    private GameController() {
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
            String playerName = JOptionPane.showInputDialog(
                    null,
                    String.format("Enter Player's %d name", (i + 1)),
                    "Players",
                    JOptionPane.QUESTION_MESSAGE);
            playerNames.add(playerName);
            playerList.add(new Player(playerName));
        }

        gameView = new MainView(playerNames);
        mPlayerPresenters = gameView.getPresenters();
        gameView.run();

        playTurn();

//        for (int turn = 0; turn < 13; turn++) {
//            for (String player : playerNames) {
//                gameView.setStatus(player + " turn. ");
//                for (int i = 0; i < 3; i++) {
//                    System.out.println("Roll");
//                }
//            }
//        }
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }

        return instance;
    }

    public static void start() {
        GameController.getInstance();
    }

    public void setPlayerPresenters(List<PlayerPresenter> mPlayerPresenters) {
        this.mPlayerPresenters = mPlayerPresenters;
    }

    public ArrayList<Dice> rollDice(ArrayList<Dice> diceList) {
        for (Dice dice : diceList) {
            dice.roll();
        }
        mDiceList = diceList;
        return diceList;
    }

    public ArrayList<Dice> rollSomeDice(ArrayList<Dice> diceList, int[] indices) {
        for (int i : indices) {
            diceList.get(i).roll();
        }
        mDiceList = diceList;
        return diceList;
    }

    private Player nextPlayer() {
        if (playerIndex >= playerList.size()) {
            playerIndex = 0;
        }

        return playerList.get(playerIndex++);
    }

    public void playTurn() {
        Player player = nextPlayer();
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

    public List<Dice> getDiceList() {
        return mDiceList;
    }
}
