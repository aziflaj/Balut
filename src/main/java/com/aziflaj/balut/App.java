package com.aziflaj.balut;

import com.aziflaj.balut.utils.BalutExceptionHandler;
import com.aziflaj.balut.utils.db.DatabaseOpenHelper;

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
                    MainView app = new MainView();
                    app.run();
                    DatabaseOpenHelper.getInstance();
                } catch (SQLException ex) {
                    //TODO: remove stack trace and handle exception on production
                    ex.printStackTrace();
                    // BalutExceptionHandler.handleException(ex);
                }
            }
        });
    }
}
