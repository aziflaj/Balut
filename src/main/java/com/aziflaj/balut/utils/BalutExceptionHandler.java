package com.aziflaj.balut.utils;

import javax.swing.*;

/**
 * An Exception handler class
 */
public class BalutExceptionHandler {

    /**
     * Shows a JOptionPane with an error message given by the exception
     *
     * @param ex The exception to handle
     */
    public static void handleException(Exception ex) {
        JOptionPane.showMessageDialog(null, ex, "Some Error Occurred", JOptionPane.ERROR_MESSAGE);
    }
}
