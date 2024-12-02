package com.cse215.g2.pet_simulator;

public class GUIUpdateLoop implements Runnable {
    public volatile boolean continueLoop = true;

    @Override
    public void run() {
        
        long nanosecondBetweenFrames = Custom.getNanoSeconds(1 / Settings.getGameFPS());
        long lastFrameUpdateTime = System.nanoTime();
        long currentTime = System.nanoTime();
        while (continueLoop) {
            currentTime = System.nanoTime();
            if (currentTime - lastFrameUpdateTime >= nanosecondBetweenFrames) {
                lastFrameUpdateTime = currentTime;
                Animal pet= Manager.getPet();
                GameGUI.setTextLabel(""+pet.getName()+" ("+pet.getCurrentLifeStageName()+", "+pet.getAge()+")");
                GameGUI.setHunger(pet.getCurrentHungerLevel());
                GameGUI.setHappiness(pet.getCurrentHappinessLevel());
                GameGUI.setPhysicalLabel(pet.getCurrentPhysicalHealthStageName());
                GameGUI.setMentalLabel(pet.getCurrentMentalHealthStageName());

                // updateAnimation();
            }
        }
    }

}
