package com.cse215.g2.pet_simulator;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PetSelectionButton extends JButton {
    public PetSelectionButton(String text, String localPath, int y) {
        super();
        Custom.xCenter(this, y, Custom.getWidthFromPercent(80), 100);
        JLabel imageLabel = new JLabel(Custom.getScaledImageIcon(localPath,70,70,Image.SCALE_SMOOTH));
        JLabel textLabel = new JLabel(text, SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        this.add(imageLabel, BorderLayout.WEST);
        this.add(textLabel, BorderLayout.CENTER);
    }

}
