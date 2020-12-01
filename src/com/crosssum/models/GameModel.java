package com.crosssum.models;

import com.crosssum.core.Cell;
import com.google.gson.Gson;

public class GameModel {
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
        board = new Cell[this.rows][this.columns];
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                board[row][column] = new Cell(Cell.CellType.EMPTY);
            }
        }
    }

    public void gameConfiguration() {
        String gameData = "[[{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":23,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":28,\"value2\":-1}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":19,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":26,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":4,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":9,\"value2\":-1}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":21,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":29,\"value2\":-1}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}]," +
                // Two
                "[{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED11\",\"value1\":15,\"value2\":16}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED10\",\"value1\":11,\"value2\":-1}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":12}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":17}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED10\",\"value1\":15,\"value2\":-1}]," +
                // Three
                "[{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":26}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":27}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":8,\"value2\":19}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}]," +
                // Four
                "[{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":19}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":6,\"value2\":16}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED10\",\"value1\":30,\"value2\":-1}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":14}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}]," +
                //Five
                "[{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":18,\"value2\":-1}," +
                "{\"type\":\"FILLED11\",\"value1\":24,\"value2\":18}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":21,\"value2\":4}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":13,\"value2\":20}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}]," +
                //Six
                "[{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":3}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED11\",\"value1\":4,\"value2\":4}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":17,\"value2\":9}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED10\",\"value1\":9,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":11,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":27,\"value2\":-1}]," +
                //Seven
                "[{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":8}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":16,\"value2\":27}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":14,\"value2\":22}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}]," +
                //Eight
                "[{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":26}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":16,\"value2\":23}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":22,\"value2\":12}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}]," +
                //Nine
                "[{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":24}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":15,\"value2\":38}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":8}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}]," +
                //Ten
                "[{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":27,\"value2\":-1}," +
                "{\"type\":\"FILLED11\",\"value1\":11,\"value2\":15}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":13,\"value2\":16}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED10\",\"value1\":17,\"value2\":-1}," +
                "{\"type\":\"FILLED11\",\"value1\":19,\"value2\":11}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}]," +
                //Eleven
                "[{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED11\",\"value1\":4,\"value2\":20}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":3}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":8,\"value2\":14}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED10\",\"value1\":6,\"value2\":-1}," +
                "{\"type\":\"FILLED10\",\"value1\":14,\"value2\":-1}]," +
                //Twelve
                "[{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":12}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED10\",\"value1\":16,\"value2\":-1}," +
                "{\"type\":\"FILLED11\",\"value1\":14,\"value2\":3}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED11\",\"value1\":8,\"value2\":14}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":11}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}]," +
                //Thirteen
                "[{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":7}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":17}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":26}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}]," +
                // Fourteen
                "[{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":12}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":29}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}," +
                "{\"type\":\"FILLED01\",\"value1\":-1,\"value2\":12}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"INPUT\",\"value1\":-1,\"value2\":5}," +
                "{\"type\":\"EMPTY\",\"value1\":-1,\"value2\":-1}]]";
        Gson gson = new Gson();
        board = gson.fromJson(gameData, Cell[][].class);
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}
