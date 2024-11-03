package com.cse215.g2.pet_simulator;

public class PetBehaviour implements Runnable {

    private static long nanosecondBetweenAge=100000000000l;
    private static boolean continueLoop=true;
    @Override
    public void run() {
        long lastAgeUpdateTime = System.nanoTime();
        long currentTime=System.nanoTime();
        while (continueLoop) {
            currentTime=System.nanoTime();
            if(currentTime-lastAgeUpdateTime>=nanosecondBetweenAge){
                lastAgeUpdateTime=currentTime;
                //updateAnimation();
            }
        }
    }
    public static void close(){continueLoop=false;}
}
