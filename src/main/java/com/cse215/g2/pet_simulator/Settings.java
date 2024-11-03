package com.cse215.g2.pet_simulator;

import java.io.PrintWriter;
import java.util.Scanner;

public class Settings {
    //TO-DO: instance verify??
    private static final String SETTINGS_SAVEFILE_NAME = "Settings.sf";
    private static final int[] FPS_OPTIONS = { 15, 30, 45, 60, 120 };
    private static final int DEFAULT_FPS_INDEX = 1;
    private static final boolean DEFAULT_PLAY_AUDIO=true;
    private static int gameFPSIndex = DEFAULT_FPS_INDEX;
    private static double timeBetweenFrames = 1f / FPS_OPTIONS[gameFPSIndex];
    private static boolean playAudio = true;

    public static void validateClass() {
        CustomMethods.validatePositiveAndSortedArray(FPS_OPTIONS, "FPS_OPTIONS");
        CustomMethods.valdateIndexIsInBounds(FPS_OPTIONS, DEFAULT_FPS_INDEX, "defaultFPSIndex");
        CustomMethods.valdateIndexIsInBounds(FPS_OPTIONS, gameFPSIndex, "gameFPSIndex");
    }

    public static void loadDefaultValues() {
        updateGameFPS(DEFAULT_FPS_INDEX);
        playAudio=DEFAULT_PLAY_AUDIO;
    }

    public static void updateGameFPS(int index) {
        try {
            CustomMethods.validatePositiveAndSortedArray(FPS_OPTIONS, "FPS_OPTIONS");
        } catch (VerifyError v) {
            updateGameFPS(DEFAULT_FPS_INDEX);
        }
        gameFPSIndex = index;
        timeBetweenFrames = 1f / FPS_OPTIONS[gameFPSIndex];
    }

    public int getGameFPS() {
        return FPS_OPTIONS[gameFPSIndex];
    }

    public static void saveCurrentSettings() {
        try (PrintWriter saveFile = new PrintWriter(CustomMethods.getFullPathString(SETTINGS_SAVEFILE_NAME))) {
            saveFile.println(gameFPSIndex);
            saveFile.println(playAudio);
        } catch (Exception e) {
        }
    }
    public static void loadSettings(){
        try(Scanner reader=new Scanner(CustomMethods.getFullPathString(SETTINGS_SAVEFILE_NAME))){

        }
    }
}