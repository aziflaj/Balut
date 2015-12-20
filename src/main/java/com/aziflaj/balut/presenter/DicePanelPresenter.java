package com.aziflaj.balut.presenter;


import com.aziflaj.balut.model.Dice;

import java.util.ArrayList;
import java.util.List;

public interface DicePanelPresenter {
    ArrayList<Dice> getDiceList();

    void throwDices(int[] indices);

    void rollAllDices();

    Dice getDiceAt(int i);
}
