package com.cse215.g2.pet_simulator;

public class PetBehaviour implements Runnable {

    private long nanosecondBetweenAge=100000000000l;
    @Override
    public void run() {
        
        long lastAgeUpdateTime = System.nanoTime();
        long currentTime=System.nanoTime();
        while (true) {
            currentTime=System.nanoTime();
            if(currentTime-lastAgeUpdateTime>=nanosecondBetweenAge){
                lastAgeUpdateTime=currentTime;
                //updateAnimation();
            }
        }
    }
}
