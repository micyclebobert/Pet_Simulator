package com.cse215.g2.pet_simulator;

import java.awt.Color;

import javax.swing.JFrame;

public class FullSceenFrame extends JFrame {
    public FullSceenFrame() {
        this(true);
    }

    public FullSceenFrame(Boolean allowReturn) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);// Set the frame to full screen
        this.setUndecorated(true); // Remove title bar for true full-screen experience
        this.getContentPane().setBackground(new Color(32, 28, 28));
        this.setLayout(null);
        this.setTitle("Pet Simulator");
        this.add(new CloseButton());
        if (allowReturn)
            this.add(new ReturnButton());
    }

}
