package com.crosssum.models;

import com.crosssum.core.Cell;
import com.crosssum.dummyClass;
import com.google.gson.Gson;

public class GameModel extends dummyClass{
    private final int columns; //No.  of columns in puzzle.
    private final int rows; // No. of rows in puzzle.
    public Cell[][] board;
//    private static UniquePartitions partitions;

    public GameModel(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
//        partitions = new UniquePartitions();
    }

    public void iniBoard() {
        Gson gson=new Gson();
//        board = new Cell[this.rows][this.columns];
//        for (int row = 0; row < this.rows; row++) {
//            for (int column = 0; column < this.columns; column++) {
//                board[row][column] = new Cell(Cell.CellType.EMPTY);
//            }
//        }
        board=gson.fromJson(gameData,Cell[][].class);
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
