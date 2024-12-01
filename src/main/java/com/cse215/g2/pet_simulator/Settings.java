package com.cse215.g2.pet_simulator;

public class Settings {
    /*TODO
     * Easy and HArd mode based on timebetweenHungerandHappiness
    */
    public static final int[] FPS_OPTIONS = { 15, 30, 45, 60, 120 };
    private static int indexOfFPS = 1;
    private static boolean playAudio = true;

    public static int getIndexOfFPS() {
        return indexOfFPS;
    }

    public static void setIndexOfFPS(int index) {
        indexOfFPS = index;
    }
    
    public static int getGameFPS() {
        return FPS_OPTIONS[indexOfFPS];
    }
    
    public static void setPlayAudio(boolean bool) {
        playAudio = bool;
    }
    
    public static boolean getPlayAudio() {
        return playAudio;
    }
}

/*
 * public static final int[] FPS_OPTIONS = { 15, 30, 45, 60, 120 };
 * private static final int DEFAULT_FPS_INDEX = 1;
 * private static final boolean DEFAULT_PLAY_AUDIO=true;
 * private int gameFPSIndex = DEFAULT_FPS_INDEX;
 * private boolean playAudio = DEFAULT_PLAY_AUDIO;
 * 
 * public void updateGameFPS(int index) {
 * gameFPSIndex = index;
 * }
 * 
 * public int getGameFPS() {
 * return FPS_OPTIONS[gameFPSIndex];
 * }
 * 
 * public void setPlayAudio(boolean bool) {
 * playAudio = bool;
 * }
 * 
 * public boolean getPlayAudio() {
 * return playAudio;
 * }
 */