package com.crosssum.controllers;

import com.crosssum.core.Cell;
import com.crosssum.models.GameModel;
import com.crosssum.screens.GameView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameController {
    public GameModel model;
    private GameView view;
    boolean isPaused = false; // to pause our game

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

    public Boolean solveBoard() {
        int filledCells = 0;   //to keep track of number of filled cells
        ArrayList<Boolean> check = new ArrayList<Boolean>();
        HashMap<Integer, Integer> map;
        boolean correct = true;

        //nested loop to go through the whole board
        for (int i = 0; i < model.getRows(); i++) {

            for (int j = 0; j < model.getColumns(); j++) {
//                System.out.println(model.board[i][j].getType());
                if (model.board[i][j].getType().equals(Cell.CellType.INPUT)) {
                    System.out.println(model.board[i][j].getFirstValue() + "----" + model.board[i][j].getSecondValue());
                    if (model.board[i][j].getFirstValue() != model.board[i][j].getSecondValue()) {
                        correct = false;
                    }
                }

            }

        }



        if (correct)
            return true;
        else
            return false;
    }

    public void submit() {
        loadInputInModel(false);
        Boolean success = solveBoard();
        if (success)
            view.showFinalMessage("Congratulation you solved the Puzzle");
        else
            view.showFinalMessage("The solution is incorrect.");
    }

    private void loadInputInModel(boolean clearInput) {
        JTextField[][] saveInput = view.getSavedInput();
        String value;

        for (int row = 0; row < model.getColumns(); row++) {
            for (int column = 0; column < model.getRows(); column++) {
                Cell cell = model.board[row][column];

                if (cell.getType() == Cell.CellType.INPUT) {
                    if (clearInput) {
                        saveInput[row][column].setText("");
                        model.board[row][column].setFirstValue(-1);
                    } else {
                        value = saveInput[row][column].getText();
                        if (!value.isEmpty())
                            model.board[row][column].setFirstValue(Integer.parseInt(value));
                    }
                }
            }
        }
    }

    public void pause() {
        isPaused = true;
        view.hideBoard();
    }

    public void resume() {
        isPaused = false;
        view.showBoard();
    }

    public void restart() {
        loadInputInModel(true); //Clear inputs
    }
}
