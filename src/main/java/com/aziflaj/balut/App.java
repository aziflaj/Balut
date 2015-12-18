package com.aziflaj.balut;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView app;
                try {
                    app = new MainView();
                    app.setVisible(true);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
