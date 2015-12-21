package com.aziflaj.balut.utils;


import javax.swing.*;

public class BalutExceptionHandler {
    public static void handleException(Exception ex) {
        JOptionPane.showMessageDialog(null, ex, "Some Error Occurred", JOptionPane.ERROR_MESSAGE);
    }
}
