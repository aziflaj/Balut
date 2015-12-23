package com.aziflaj.balut;

import com.aziflaj.balut.model.Dice;
import com.aziflaj.balut.model.Player;
import com.aziflaj.balut.view.MainView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameController {
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
            String player = JOptionPane.showInputDialog(
                    null,
                    String.format("Enter Player's %d name", (i + 1)),
                    "Players",
                    JOptionPane.QUESTION_MESSAGE);
            playerNames.add(player);
        }

        gameView = new MainView(playerNames);
        gameView.run();

        for (int turn = 0; turn < 13; turn++) {
            for (String player : playerNames) {
                gameView.setStatus(player + " turn. ");
                for (int i = 0; i < 3; i++) {
                    System.out.println("Roll");
                }
            }
        }
    }

    public static void start() {
        new GameController();
    }

    public static ArrayList<Dice> rollDice(ArrayList<Dice> diceList) {
        for (Dice dice : diceList) {
            dice.roll();
        }
        return diceList;
    }

    private Player nextPlayer() {
        playerIndex++;
        if (playerIndex > playerList.size()) {
            playerIndex = 0;
        }

        return playerList.get(playerIndex);
    }

    public static ArrayList<Dice> rollSomeDice(ArrayList<Dice> diceList, int[] indices) {
        for (int i : indices) {
            diceList.get(i).roll();
        }
        return diceList;
    }
}
