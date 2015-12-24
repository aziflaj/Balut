package com.aziflaj.balut.presenter;

import com.aziflaj.balut.utils.GameCategory;
import com.aziflaj.balut.view.player.PlayerView;

public interface PlayerPresenter {
    void play();

    void addPoints(GameCategory gameCategory, int points);

    int calculateUpperPoints();

    int calculateLowerPoints();

    int calculateTotal();

    PlayerView getView();

    int calculatePoints(int index);
}
