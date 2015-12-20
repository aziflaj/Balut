package com.aziflaj.balut.presenter;


import com.aziflaj.balut.model.Dice;

import java.util.ArrayList;

public interface DicePanelPresenter {
    ArrayList<Dice> getDiceList();

    void throwDices(int[] indices);

    void rollAllDices();

    Dice getDiceAt(int i);
}
