package com.aziflaj.balut.presenter;


import java.util.List;

public interface DicePanelPresenter {
    List<? extends Object> getDiceList();

    void throwDices(int[] indices);

    void throwAllDices();
}
