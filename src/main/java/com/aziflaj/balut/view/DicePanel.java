package com.aziflaj.balut.view;

import com.aziflaj.balut.presenter.DicePanelPresenter;
import com.aziflaj.balut.presenter.DicePanelPresenterImpl;

import javax.swing.*;

public class DicePanel extends JPanel {
    DicePanelPresenter mPresenter;

    public DicePanel() {
        mPresenter = new DicePanelPresenterImpl();

        mPresenter.throwAllDices();
    }
}
