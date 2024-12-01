package com.cse215.g2.pet_simulator;

public class PetBehaviour implements Runnable {

    private static long nanosecondBetweenAge = Custom.getNanoSeconds(1);
    private static long nanosecondBetweenHunger = Custom.getNanoSeconds(1);
    private static long nanosecondBetweenHappiness = Custom.getNanoSeconds(1);
    private static volatile boolean continueLoop = true;

    @Override
    public void run() {
        long currentTime = System.nanoTime();
        long lastAgeUpdateTime = currentTime;
        long lastHungerUpdateTime = currentTime;
        long lastHappinessUpdateTime = currentTime;
        while (continueLoop) {
            currentTime = System.nanoTime();
            if (currentTime - lastAgeUpdateTime >= nanosecondBetweenAge) {
                Manager.getPet().updateAge();
                lastAgeUpdateTime = currentTime;
                // updateAnimation();
            }
            if (currentTime - lastHungerUpdateTime >= nanosecondBetweenHunger) {
                Manager.getPet().DecrementCurrentHungerLevel();
                lastHungerUpdateTime = currentTime;
                // updateAnimation();
            }
            if (currentTime - lastHappinessUpdateTime >= nanosecondBetweenHappiness) {
                Manager.getPet().DecrementCurrentHappinessLevel();
                lastHappinessUpdateTime = currentTime;
                // updateAnimation();
            }
        }
    }

    public static void close() {
        continueLoop = false;
    }
}
