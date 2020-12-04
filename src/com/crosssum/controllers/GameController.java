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
//                switch (model.board[i][j].getType()) {
//
//                    //check sum if its a filled boards
//                    case FILLED01: {
//                        filledCells++;
//                        int column = j + 1;
//                        int sum = 0;
//                        map = new HashMap<Integer, Integer>();
//                        //continues to add horizontally until next cell is not an INPUT type
//                        while (column <= model.getColumns() && model.board[i][column].getType() == Cell.CellType.INPUT) {       //horizontal sum check
//
//                            int cell = model.board[i][column].getFirstValue();   //getting cell value
//
//                            if (map.containsKey(cell)) {        //if already has number as input return false
//                                return false;
//                            } else {
//                                map.put(cell, cell);
//                            }
//                            sum += cell;                      //adding the cell value
//                            column++;
//                        }
//
//                        map.clear();                             //clearing hashmap after use
//
//                        if (sum == model.board[i][j].getSecondValue())
//                            check.add(true);
//                        else
//                            return false;
//                    }
//
//                    break;
//
//                    case FILLED10: {                                               //vertical sum check
//                        filledCells++;
//                        int row = i + 1;
//                        int sum = 0;
//                        map = new HashMap<Integer, Integer>();
//
//                        while (row <= model.getRows() && model.board[row][j].getType() == Cell.CellType.INPUT) {
//
//                            int cell = model.board[row][j].getFirstValue();
//
//                            if (map.containsKey(cell)) {                      //if already has number as input return false
//                                return false;
//                            } else {
//                                map.put(cell, cell);
//                            }
//                            sum += cell;
//                            row++;
//                        }
//                        map.clear();
//
//                        if (sum == model.board[i][j].getFirstValue())
//                            check.add(true);
//                        else
//                            return false;
//                    }
//                    break;
//
//                    case FILLED11: {
//
//                        filledCells++;
//                        int row = i + 1;
//                        int column = j + 1;
//                        int sumRows = 0;
//                        int sumColumns = 0;
//                        map = new HashMap<Integer, Integer>();
//                        //checking row sum
//                        while (column <= model.getColumns() && model.board[i][column].getType() == Cell.CellType.INPUT) {       //horizontal sum check
//
//                            int cell = model.board[i][column].getFirstValue();
//
//                            if (map.containsKey(cell)) {      //if already has number as input return false
//                                return false;
//                            } else {
//                                map.put(cell, cell);         //insert in hashmap if not already present in the map
//                            }
//
//                            sumColumns += cell;
//                            column++;
//                        }
//                        map.clear();
//
//                        //checking column sum
//                        while (row <= model.getRows() && model.board[row][j].getType() == Cell.CellType.INPUT) {     //vertical sum check
//
//                            int cell = model.board[row][j].getFirstValue();
//
//                            if (map.containsKey(cell)) {                      //if already has number as input return false
//                                return false;
//                            } else {
//                                map.put(cell, cell);
//                            }
//
//                            sumRows += cell;
//                            row++;
//                        }
//                        map.clear();
//
//                        if (sumRows == model.board[i][j].getFirstValue() && sumColumns == model.board[i][j].getSecondValue())
//                            check.add(true);
//                        else
//                            return false;
//
//                    }
//                    break;
//                    default: {
//                    }
//                    ;
//
//                }

            }

        }

//        boolean correct = true;

//        for (int i = 0; i < filledCells; i++) {
//            if (check.get(i) != true)
//                correct = false;
//        }

        if (correct)
            return true;
        else
            return false;
    }

    public void submit() {
        loadInputInModel(false);
        Boolean success = solveBoard();
        if (success)
            System.out.println("The board is solved!");
        else
            System.out.println("The solution is incorrect.");
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
