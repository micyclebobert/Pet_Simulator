package com.cse215.g2.pet_simulator;

public class Settings {
    public static final int[] FPS_OPTIONS = { 15, 30, 45, 60, 120 };
    private static final int DEFAULT_FPS_INDEX = 1;
    private static final boolean DEFAULT_PLAY_AUDIO=true;
    private static int gameFPSIndex = DEFAULT_FPS_INDEX;
    private static boolean playAudio = DEFAULT_PLAY_AUDIO;

    public static void updateGameFPS(int index) {
        try {
            CustomMethods.validatePositiveAndSortedArray(FPS_OPTIONS, "FPS_OPTIONS");
        } catch (VerifyError v) {
            updateGameFPS(DEFAULT_FPS_INDEX);
        }
        gameFPSIndex = index;
    }

    public static int getGameFPS() {
        return FPS_OPTIONS[gameFPSIndex];
    }

    public static void setPlayAudio(boolean bool) {
        playAudio = bool;
    }

    public static boolean getPlayAudio() {
        return playAudio;
    }

    //Validation
    public static void validateClass() {
        CustomMethods.validatePositiveAndSortedArray(FPS_OPTIONS, "FPS_OPTIONS");
        CustomMethods.valdateIndexIsInBounds(FPS_OPTIONS, DEFAULT_FPS_INDEX, "defaultFPSIndex");
    }
}