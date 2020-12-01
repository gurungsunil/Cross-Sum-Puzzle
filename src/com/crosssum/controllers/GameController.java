package com.crosssum.controllers;

import com.crosssum.models.GameModel;
import com.crosssum.screens.GameView;

public class GameController {
    public GameModel model;
    private GameView view;

    public GameController(final int columns, final int rows) {
        this.model = new GameModel(columns, rows);
        initPuzzle(model);
    }

    private void initPuzzle(GameModel model) {
        ButtonController btn = new ButtonController();
        btn.getButtonsReady(this);
        model.iniBoard();
        this.view = new GameView(this, btn.getView());
    }

    void loadPreConfigGame() {
        model.gameConfiguration();
        view.updateView();
    }
}
