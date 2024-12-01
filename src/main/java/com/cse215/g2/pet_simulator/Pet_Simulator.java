package com.cse215.g2.pet_simulator;

import java.awt.Toolkit;

public class Pet_Simulator {
    // Background, Toys, Pet, Action, UI
    // If action is going on and new action
    // then cancel the current and start new
    // Actions update variables after it is over
    public static GameData gameData;

    public static void main(String[] args) {
        initialize();
        Animal a = new Animal("l");
        a.sicknessEvent();
        // MainMenu.open();
        Thread _GUI = new Thread(new GUIManager());
        // Thread audio = new Thread();
        _GUI.start();
        // behaviour.start();
        System.out.println("Hello World!" + a.getAge());
    }
    
    public static void validateClasses() {
        Animal.validateClass();
    }

    
    /**
     * These are the things that must happen right after the game starts
     */
    public static void initialize() {
        validateClasses();
        Custom.setScreenSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
}
