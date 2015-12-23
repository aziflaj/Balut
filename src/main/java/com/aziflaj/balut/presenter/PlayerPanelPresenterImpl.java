package com.aziflaj.balut.presenter;

public class PlayerPanelPresenterImpl implements PlayerPanelPresenter {
    PlayerPresenter mPresenter;

    public PlayerPanelPresenterImpl() {
        mPresenter = new PlayerPresenterImpl("");
    }

}
