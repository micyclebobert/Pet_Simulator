package com.cse215.g2.pet_simulator;

public class Settings {
    public static final int[] FPS_OPTIONS = { 15, 30, 45, 60, 120 };
    private static final int DEFAULT_FPS_INDEX = 1;
    private static final boolean DEFAULT_PLAY_AUDIO=true;
    private int gameFPSIndex = DEFAULT_FPS_INDEX;
    private boolean playAudio = DEFAULT_PLAY_AUDIO;

    public void updateGameFPS(int index) {
        gameFPSIndex = index;
    }

    public int getGameFPS() {
        return FPS_OPTIONS[gameFPSIndex];
    }

    public void setPlayAudio(boolean bool) {
        playAudio = bool;
    }

    public boolean getPlayAudio() {
        return playAudio;
    }

    //Validation
    // public static void validateClass() {
    //     Custom.validatePositiveAndSortedArray(FPS_OPTIONS, "FPS_OPTIONS");
    //     Custom.valdateIndexIsInBounds(FPS_OPTIONS, DEFAULT_FPS_INDEX, "defaultFPSIndex");
    // }
}