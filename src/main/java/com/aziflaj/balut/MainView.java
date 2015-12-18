package com.aziflaj.balut;


import com.aziflaj.balut.utils.ResourceHelper;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class MainView extends JFrame {

    public MainView() throws IOException {
        URL dicesUrl = ResourceHelper.getResourceURL("dice-faces.png");
        File dices = new File(String.valueOf(dicesUrl));
        System.out.println("Can read: " + dices.canRead());
        if (dices.canRead()) {
            FileReader reader = new FileReader(dices);
            System.out.println("encoding: " + reader.getEncoding());
        }
    }
}
