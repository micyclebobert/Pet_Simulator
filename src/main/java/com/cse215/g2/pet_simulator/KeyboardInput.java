package com.cse215.g2.pet_simulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown()){
            System.out.println("here");
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}