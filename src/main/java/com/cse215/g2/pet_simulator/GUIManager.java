package com.cse215.g2.pet_simulator;

public class GUIManager implements Runnable {

    @Override
    public void run() {
        MainMenu.setup();
        GameGUI.setup();
        GameGUI.open();
    }
    
}
