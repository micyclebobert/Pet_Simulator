package com.cse215.g2.pet_simulator;

import javax.swing.JFrame;

public class FullSceenFrame extends JFrame {
    public FullSceenFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);// Set the frame to full screen
        this.setUndecorated(true); // Remove title bar for true full-screen experience
        this.setVisible(true);
    }

    public FullSceenFrame(String title) {
        this();
        this.setTitle(title);
    }
}
