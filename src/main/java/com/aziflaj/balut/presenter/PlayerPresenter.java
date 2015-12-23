package com.aziflaj.balut.presenter;

import com.aziflaj.balut.utils.GameCategory;

public interface PlayerPresenter {
    void play();
    void addPoints(GameCategory gameCategory);
    int calculateUpperPoints();
    int calculateLowerPoints();
    int calculateTotal();
}
