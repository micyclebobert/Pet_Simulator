package com.cse215.g2.pet_simulator;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Animal implements Serializable{
    /*
     * States are temporary, Stages are longer term
     */
    private final String name;
    private int age = 0;

    public static final String[] LIFE_STAGE_NAMES = { "Newborn", "Fledgling", "Prepubesent", "Teenager", "Adult",
            "Old" };
    public static final int[] LIFE_STAGE_AGE_RANGES = { 2, 4, 8, 10, 20 }; // Range of lifeStages[first] is 0 to
    // lifeStagesAge[first]
    // Range of lifeStages[second] is (lifeStagesAge[first] + 1) to
    // lifeStagesAge[second]
    // Range of lifeStages[last] is (lifeStagesAge[last] + 1) to
    // infinity
    private int currentHungerLevel = 50;

    public static final String[] HUNGER_STATE_NAMES = { "Very Hungry", "Hungry", "Well Fed" };
    public static final int[] HUNGER_STATE_RANGES = { 10, 90 };
    private int totalSumOfHungerWhenFeeding = 50;
    private int countOfFeeding = 1; // Since we avg it I'm giving it a starting value
    // (to avoid division by 0 err)
    public static final String[] PHYSICAL_HEALTH_STAGE_NAMES = { "Malnourished", "Fit", "Overweight" };
    public static final int[] PHYSICAL_HEALTH_STAGE_RANGES = { 10, 90 };
    private int currentHappinessLevel = 50;

    public static final String[] HAPPINESS_STATE_NAMES = { "Depressed", "Balanaced", "Moody" };
    public static final int[] HAPPINESS_STATE_RANGES = { 10, 90 };
    private int totalSumOfHappinessWhenPatting = 50; // Since we avg it I'm giving it a starting value
    private int patCount = 1;
    // (to avoid division by 0 err)
    // private int toyCount = 0;
    // private int sleepCount = 0;
    public static final String[] MENTAL_HEALTH_STAGE_NAMES = { "Sad", "Okay", "Happy" };
    public static final int[] MENTAL_HEALTH_STAGE_RANGES = { 10, 90 };
    
    public static final String TRIVIAS[][] = { { "What is the capital of Japan", "Tokyo" },
    { "What am I thinking right now?", "Nothing" } };

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void updateAge() {
        age++;
        if (Math.random() < 0.001)
            sicknessEvent();
    }

    public void sicknessEvent() {
        String[] random = Custom.getRandom(TRIVIAS);
        String answer = "";
        while (!answer.trim().equalsIgnoreCase(random[1])) {
            answer = JOptionPane.showInputDialog(random[0]);
        }
    }

    public int getCurrentLifeStageIndex() {
        return Custom.getIndexFromRange(LIFE_STAGE_AGE_RANGES, age);
    }

    public String getCurrentLifeStageName() {
        return LIFE_STAGE_NAMES[getCurrentLifeStageIndex()];
    }

    public int getCurrentHungerStateIndex() {
        return Custom.getIndexFromRange(HUNGER_STATE_RANGES, currentHungerLevel);
    }

    public String getCurrentHungerStateName() {
        return HUNGER_STATE_NAMES[getCurrentHungerStateIndex()];
    }

    public int getCurrentPhysicalHealthStageIndex() {
        int avg = totalSumOfHungerWhenFeeding / countOfFeeding;
        return Custom.getIndexFromRange(PHYSICAL_HEALTH_STAGE_RANGES, avg);
    }

    public String getCurrentPhysicalHealthStageName() {
        return PHYSICAL_HEALTH_STAGE_NAMES[getCurrentPhysicalHealthStageIndex()];
    }

    public int getCurrentMentalHealthStageIndex() {
        // int min = Math.min(toyCount, Math.min(patCount, sleepCount));
        // return Custom.getIndexFromRange(MENTAL_HEALTH_STAGE_RANGES, min);
        int avg = totalSumOfHappinessWhenPatting / patCount;
        return Custom.getIndexFromRange(MENTAL_HEALTH_STAGE_RANGES, avg);
    }

    public String getCurrentMentalHealthStageName() {
        return MENTAL_HEALTH_STAGE_NAMES[getCurrentMentalHealthStageIndex()];
    }

    public int getCurrentHungerLevel() {
        return currentHungerLevel;
    }

    private void incrementCurrentHungerLevel() {
        int newCurrentHungerLevel = currentHungerLevel + 50;
        currentHungerLevel = newCurrentHungerLevel < 100 ? newCurrentHungerLevel : 100;
    }

    public void DecrementCurrentHungerLevel() {
        currentHungerLevel = currentHungerLevel > 0 ? currentHungerLevel - 1 : 0;
    }

    public int getCurrentHappinessLevel() {
        return currentHappinessLevel;
    }

    private void incrementCurrentHappinessLevel() {
        int newCurrentHappinessLevel = currentHappinessLevel + 50;
        currentHappinessLevel = newCurrentHappinessLevel < 100 ? newCurrentHappinessLevel : 100;
    }

    public void DecrementCurrentHappinessLevel() {
        currentHappinessLevel = currentHappinessLevel > 0 ? currentHappinessLevel - 1 : 0;
    }

    public void pat() {
        patCount++;
        totalSumOfHappinessWhenPatting += currentHappinessLevel;
        incrementCurrentHappinessLevel();
    }

    public void feed() {
        countOfFeeding++;
        totalSumOfHungerWhenFeeding += currentHungerLevel;
        incrementCurrentHungerLevel();
    }

    public static Animal askForNew() {
        return new Animal(JOptionPane.showInputDialog("Input new pet name"));
    }

    public static void validateClass() {
        validateArray(LIFE_STAGE_NAMES, LIFE_STAGE_AGE_RANGES, "LIFE_STAGE");
        validateArray(HUNGER_STATE_NAMES, HUNGER_STATE_RANGES, "HUNGER_STATE");
        validateArray(PHYSICAL_HEALTH_STAGE_NAMES, PHYSICAL_HEALTH_STAGE_RANGES, "PHYSICAL_HEALTH");
        validateArray(MENTAL_HEALTH_STAGE_NAMES, MENTAL_HEALTH_STAGE_RANGES, "MENTAL_HEALTH");
    }

    public static void validateArray(String[] nameArray, int[] rangeArray, String nameOfArray) {
        validateNameAndRangeLengths(nameArray, rangeArray, nameOfArray);
        validateRangeArray(rangeArray, nameOfArray);
    }

    public static void validateNameAndRangeLengths(String[] nameArray, int[] rangeArray, String nameOfArray) {
        if (nameArray.length - 1 != rangeArray.length) {
            throw new VerifyError(nameOfArray + "_NAMES length - 1 does not equal " + nameOfArray + "_RANGES length");
        }
    }

    public static void validateRangeArray(int[] rangeArray, String nameOfArray) {
        if (rangeArray[rangeArray.length - 1] > 100) {
            throw new VerifyError(rangeArray + "_RANGES [" + (rangeArray.length - 1) + "] is greater than 100");
        }
    }

    public Animal(String name) {
        this.name = name;
    }
}
