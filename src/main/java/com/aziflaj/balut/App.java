package com.aziflaj.balut;

import javax.swing.*;

/**
 * The entry point of the application, running everything in parallel
 * threads using the {@code SwingUtilities.invokeLater()} method
 */
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
