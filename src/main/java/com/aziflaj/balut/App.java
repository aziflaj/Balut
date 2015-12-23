package com.aziflaj.balut;

import com.aziflaj.balut.utils.BalutExceptionHandler;
import com.aziflaj.balut.utils.db.DatabaseOpenHelper;
import com.aziflaj.balut.view.MainView;

import javax.swing.*;
import java.sql.SQLException;

/**
 * The entry point of the application, running everything in parallel
 * threads using the {@code SwingUtilities.invokeLater()} method
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
//                    MainView app = new MainView();
//                    app.run();
                    new GameController();
                    DatabaseOpenHelper.getInstance();
                } catch (SQLException ex) {
                     BalutExceptionHandler.handleException(ex);
                }
            }
        });
    }
}
