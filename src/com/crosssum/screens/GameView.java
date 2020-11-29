package com.crosssum.screens;

import com.crosssum.controllers.GameController;
import com.crosssum.core.Cell;
import com.crosssum.core.LinePanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GameView {
    private GameController controller;
    private JTextField[][] cells;
    private JPanel currentBoard;

    private JFrame frame;
    private int gridSizeX;
    private int gridSizeY;

    public GameView(GameController controller) {
        if (controller != null) {
            this.controller = controller;
            gridSizeX = controller.model.getRows();
            gridSizeY = controller.model.getColumns();
        }
        frame = new JFrame("Puzzle Cross Sums");
        int frameSize = 60;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x = frameSize*gridSizeX;
        int y = frameSize*gridSizeY;
        frame.setSize(x, y);
        frame.setResizable(false);
        currentBoard= getBoardUi(controller.model.board);
        frame.getContentPane().add(currentBoard);
        frame.pack();
        frame.setSize(x,y);
        frame.setVisible(true);
    }

    private JPanel getBoardUi(Cell[][] board){
        cells = new JTextField[gridSizeX][gridSizeY];
        JPanel panel = new JPanel(new GridLayout(gridSizeX,gridSizeY));
        for(int row = 0; row < gridSizeX; row++)
        {
            for(int column = 0; column < gridSizeY; column++)
            {
                JFormattedTextField textField = null;

                //tracking the type of each cell
                Cell cell = board[row][column];
                //adding extra panel that will overlay the cells that are non-playable with game level numbers and diagonal line
                JPanel diagonalPanel = null;

                //according to type of cell, populate
                switch (cell.getType())
                {
                    case EMPTY:
                        textField = new JFormattedTextField("");
                        settingTextField(textField);
                        textField.setBorder(new LineBorder(Color.GRAY,1));
                        panel.add(textField);
                        break;

                    case INPUT:
                        textField = new JFormattedTextField("");
                        textField.setHorizontalAlignment(JTextField.CENTER);
                        textField.setBorder(new LineBorder(Color.GRAY,1));
                        //When you load a game, there is some data exists. We have to check to make sure we are displaying the saved input
                        if(cell.getFirstValue()!=-1)
                            textField.setValue(cell.getFirstValue());
                        panel.add(textField);
                        break;

                    case FILLED01:
                        textField = new JFormattedTextField(cell.getSecondValue());
                        settingTextField(textField);
                        //adding diagonal line in board cell
                        diagonalPanel = new LinePanel(new BorderLayout(), textField, true);
                        diagonalPanel.setBorder(new LineBorder(Color.GRAY,1));
                        panel.add(diagonalPanel);
                        break;

                    case FILLED10:
                        textField = new JFormattedTextField(cell.getFirstValue());
                        settingTextField(textField);
                        //adding diagonal line in board cell
                        diagonalPanel = new LinePanel(new BorderLayout(), textField, false);
                        diagonalPanel.setBorder(new LineBorder(Color.GRAY,1));
                        panel.add(diagonalPanel);
                        break;

                    case FILLED11:
                        textField = new JFormattedTextField(cell.getFirstValue());
                        JFormattedTextField textFieldRIGHT = new JFormattedTextField(cell.getSecondValue());
                        settingTextField(textField);
                        settingTextField(textFieldRIGHT);
                        //using constructor that expects two text values to place in board cell
                        diagonalPanel = new LinePanel(new BorderLayout(), textField, textFieldRIGHT);
                        diagonalPanel.setBorder(new LineBorder(Color.GRAY,1));
                        panel.add(diagonalPanel);
                        break;

                    default:
                        break;
                }

                //placing textfield value in input array to track user input
                this.cells[row][column] = textField;
            }
        }

        return panel;
    }

    private void settingTextField(JTextField txt) {
        txt.setBackground(Color.black);
        txt.setForeground(Color.white);
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txt.setEditable(false);
    }
}
