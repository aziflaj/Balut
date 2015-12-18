package com.aziflaj.balut;


import com.aziflaj.balut.utils.ResourceHelper;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class MainView extends JFrame {
    JButton diceRollBtn; // the button that should start rolling the dices
    ArrayList<JButton> diceList; // the list of 5 dices

    public MainView() {
        // create the leftmost panel, where the diceRollBtn and the dices will show up
        JPanel dicePanel = new JPanel();
        dicePanel.setLayout(new GridLayout(6, 1, 5, 5));

        diceRollBtn = new JButton("Hidh Zarat");
        dicePanel.add(diceRollBtn);

        diceList = new ArrayList<>();
        URL questionDiceUrl = ResourceHelper.getResourceURL("question_dice.png");
        System.out.println(questionDiceUrl);

        for (int i = 0; i < 5; i++) {
            JButton dice = new JButton(new ImageIcon(questionDiceUrl));
            diceList.add(dice);
            dicePanel.add(dice);
        }


        // Set everything in its pace in the MainView
        this.setLayout(new GridLayout(1, 3));
        this.add(dicePanel);

        this.pack(); // pack the UI
    }

    public void run() {
        this.setTitle("Balut");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
