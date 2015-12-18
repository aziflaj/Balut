package com.aziflaj.balut;

import com.aziflaj.balut.view.DicePanel;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                MainView app = new MainView();
//                app.run();

                DicePanel panel = new DicePanel();
            }
        });
    }
}
