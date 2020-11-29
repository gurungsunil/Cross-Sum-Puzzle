package com.crosssum.controllers;

import com.crosssum.models.GameModel;
import com.crosssum.screens.GameView;

public class GameController {
    public GameModel model;
    public GameView view;

    public GameController(final int columns, final int rows) {
        this.model = new GameModel(columns, rows);
        initPuzzle(model);
    }

    private void initPuzzle(GameModel model) {
        model.iniBoard();
        this.view=new GameView(this);
    }
}
