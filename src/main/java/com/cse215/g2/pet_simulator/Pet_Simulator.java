package com.cse215.g2.pet_simulator;

import java.awt.Toolkit;

public class Pet_Simulator {
    public static GameData gameData;

    public static void main(String[] args) {
        initialize();
        Thread _GUI = new Thread(new Manager());
        _GUI.start();
    }

    
    /**
     * These are the things that must happen right after the game starts
     */
    public static void initialize() {
        Custom.setScreenSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
}
