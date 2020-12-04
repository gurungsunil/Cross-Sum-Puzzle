package com.crosssum.controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController {
    private GameController gameControl;
    //Buttons UI
    private JButton submitButton; // submit button in the interface
    private JButton startGame; // choose game button in the interface
    private JPanel mainPanel;


    void getButtonsReady(GameController control) {
        this.gameControl = control;
        startGame = new JButton("Start Game");
        submitButton = new JButton("Submit Answer");
        mainPanel = new JPanel(); // JPanel object reference

        //Adding Actions Listener
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameControl.loadPreConfigGame();
                toggleButtons();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameControl.submit();
            }
        });
        mainPanel.add(startGame).setVisible(true);
        mainPanel.add(submitButton).setVisible(false);
    }

    public JComponent getView() {
        return mainPanel;
    }

    private void toggleButtons() {
        submitButton.setVisible(true);
        startGame.setVisible(false);
    }
}
