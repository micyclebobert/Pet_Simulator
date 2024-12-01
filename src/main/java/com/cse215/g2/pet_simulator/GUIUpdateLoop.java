package com.cse215.g2.pet_simulator;

public class GUIUpdateLoop implements Runnable {
    public volatile boolean continueLoop;

    @Override
    public void run() {
        
        long nanosecondBetweenFrames = Custom.getNanoSeconds(1 / new Settings().getGameFPS());
        long lastFrameUpdateTime = System.nanoTime();
        long currentTime = System.nanoTime();
        while (continueLoop) {
            currentTime = System.nanoTime();
            if (currentTime - lastFrameUpdateTime >= nanosecondBetweenFrames) {
                // System.out.println();
                lastFrameUpdateTime = currentTime;
                // updateAnimation();
            }
        }
    }

}
