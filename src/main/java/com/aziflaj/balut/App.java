package com.aziflaj.balut;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView app = new MainView();
                app.run();
            }
        });
    }
}
