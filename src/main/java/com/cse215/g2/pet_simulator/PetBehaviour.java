package com.cse215.g2.pet_simulator;

public class PetBehaviour implements Runnable {

    private static long nanosecondBetweenAge = Custom.getNanoSeconds(1);
    private static long nanosecondBetweenHunger = Custom.getNanoSeconds(1);
    private static boolean continueLoop = true;

    @Override
    public void run() {
        long currentTime = System.nanoTime();
        long lastAgeUpdateTime = currentTime;
        long lastHungerUpdateTime = currentTime;
        while (continueLoop) {
            currentTime = System.nanoTime();
            if (currentTime - lastAgeUpdateTime >= nanosecondBetweenAge) {
                lastAgeUpdateTime = currentTime;
                // updateAnimation();
            }
            if (currentTime - lastHungerUpdateTime >= nanosecondBetweenHunger) {
                lastHungerUpdateTime = currentTime;
                // updateAnimation();
            }
        }
    }

    public static void close() {
        continueLoop = false;
    }
}
