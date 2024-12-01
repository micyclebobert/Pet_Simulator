package com.cse215.g2.pet_simulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener, Runnable {
    

    private volatile boolean ctrl = false;
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("here   rrr");
        if(e.isControlDown())ctrl=true;
        if(e.isControlDown())System.out.println("ctrl");;
        if(e.getKeyChar() == 'w') System.out.println("WW");
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(!e.isControlDown())ctrl=false;
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run() {
    }
    
}
