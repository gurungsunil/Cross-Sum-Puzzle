package com.crosssum.core;

import javax.swing.*;
import java.awt.*;

public class LinePanel extends JPanel {
    public LinePanel(LayoutManager layout, JTextField textField, Boolean align) {
        super(layout);
        this.setBackground(Color.black);
        settingTxt(textField);
        if (align) {
            textField.setHorizontalAlignment(JTextField.RIGHT);
            this.add(textField, BorderLayout.NORTH);
        } else {
            textField.setHorizontalAlignment(JTextField.LEFT);
            this.add(textField, BorderLayout.SOUTH);
        }
    }

    public LinePanel(LayoutManager layout, JTextField textFieldLEFT, JTextField textFieldRIGHT) {
        super(layout);
        this.setBackground(Color.black);

        settingTxt(textFieldLEFT);
        settingTxt(textFieldRIGHT);

        textFieldLEFT.setHorizontalAlignment(JTextField.LEFT);
        textFieldRIGHT.setHorizontalAlignment(JTextField.RIGHT);

        this.add(textFieldLEFT, BorderLayout.SOUTH);
        this.add(textFieldRIGHT, BorderLayout.NORTH);

    }


    public void settingTxt(JTextField txt) {
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setForeground(Color.white);
    }
}
