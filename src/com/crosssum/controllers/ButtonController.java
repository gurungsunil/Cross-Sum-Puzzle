package com.crosssum.controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController {
    private GameController gameControl;
    //Buttons UI
    private JButton pauseButton; // pause button in the interface
    private JButton restartButton; // restart button in the interface
    private JButton submitButton; // submit button in the interface
    private JButton startGame; // choose game button in the interface
    private JPanel mainPanel;


    void getButtonsReady(GameController control) {
        this.gameControl = control;
        pauseButton= new JButton("Pause");
        restartButton=new JButton("Restart");
        startGame = new JButton("Start Game");
        submitButton = new JButton("Submit Answer");
        mainPanel = new JPanel(); // JPanel object reference

        //Adding Actions Listener
        pauseButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(!gameControl.isPaused) {
                    pauseButton.setText("Resume");
                    gameControl.pause();
                }
                else {
                    pauseButton.setText("Pause");
                    gameControl.resume();
                }
            }
        });
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameControl.loadPreConfigGame();
                toggleButtons();
            }
        });
        restartButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                gameControl.restart();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameControl.submit();
            }
        });
        mainPanel.add(pauseButton).setVisible(false);
        mainPanel.add(restartButton).setVisible(false);
        mainPanel.add(startGame).setVisible(true);
        mainPanel.add(submitButton).setVisible(false);
    }

    public JComponent getView() {
        return mainPanel;
    }

    private void toggleButtons() {
        submitButton.setVisible(true);
        startGame.setVisible(false);
        pauseButton.setVisible(true);
        restartButton.setVisible(true);
    }
}
