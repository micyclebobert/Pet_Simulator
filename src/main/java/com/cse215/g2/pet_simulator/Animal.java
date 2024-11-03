package com.cse215.g2.pet_simulator;

public class Animal {
    /*
     * States are temporary, Stages are longer term
     */
    String name;
    int age = 0;

    public static final String[] LIFE_STAGE_NAMES = { "Newborn", "Fledgling", "Prepubesent", "Teenager", "Adult", "Old" };
    public static final int[] LIFE_STAGE_AGE_RANGES = { 2, 4, 8, 10, 20 }; // Range of lifeStages[first] is 0 to
                                                                // lifeStagesAge[first]
    // Range of lifeStages[second] is (lifeStagesAge[first] + 1) to
    // lifeStagesAge[second]
    // Range of lifeStages[last] is (lifeStagesAge[last] + 1) to
    // infinity
    int currentHungerLevel;

    public static final String[] HUNGER_STATE_NAMES = { "Very Hungry", "Hungry", "Well Fed" };
    public static final int[] HUNGER_STATE_RANGES = { 10, 90 };
    int totalSumOfHungerWhenFeeding = 50, countOfFeeding = 1; // Since we avg it I'm giving it a starting value (to
                                                              // avoid division by 0 err)
    public static final String[] PHYSICAL_HEALTH_STAGE_NAMES = { "Malnourished", "Fit", "Overweight" };
    public static final int[] PHYSICAL_HEALTH_STAGE_RANGES = { 10, 90 };
    int toyCount = 0, patCount = 0, sleepCount = 0;
    public static final String[] MENTAL_HEALTH_STAGE_NAMES = { "Sad", "Okay", "Happy" };
    public static final int[] MENTAL_HEALTH_STAGE_RANGES = { 10, 90 };

    /**
     * @return
     *         Example {10, 90}
     *         return 0 if in between 0 to 10
     *         return 1 if in between 10 to 90
     *         return 2 if above 90+
     */


     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void updateAge(){age++;}
    public int getCurrentLifeStageIndex() {
        return CustomMethods.getIndexFromRange(LIFE_STAGE_AGE_RANGES, age);
    }

    public String getCurrentLifeStageName() {
        return LIFE_STAGE_NAMES[getCurrentLifeStageIndex()];
    }

    public int getCurrentHungerStateIndex() {
        return CustomMethods.getIndexFromRange(HUNGER_STATE_RANGES, currentHungerLevel);
    }

    public String getCurrentHungerStateName() {
        return HUNGER_STATE_NAMES[getCurrentHungerStateIndex()];
    }

    public int getCurrentPhysicalHealthStageIndex() {
        int avg = totalSumOfHungerWhenFeeding / countOfFeeding;
        return CustomMethods.getIndexFromRange(PHYSICAL_HEALTH_STAGE_RANGES, avg);
    }

    public String getCurrentPhysicalHealthStageName() {
        return PHYSICAL_HEALTH_STAGE_NAMES[getCurrentPhysicalHealthStageIndex()];
    }

    public int getCurrentMentalHealthStageIndex() {
        int min = Math.min(toyCount, Math.min(patCount, sleepCount));
        return CustomMethods.getIndexFromRange(MENTAL_HEALTH_STAGE_RANGES, min);
    }

    public String getCurrentMentalHealthStageName() {
        return MENTAL_HEALTH_STAGE_NAMES[getCurrentMentalHealthStageIndex()];
    }

    public int getCurrentHungerLevel() {
        return currentHungerLevel;
    }

    public void setCurrentHungerLevel(int newCurrentHungerLevel) {
        currentHungerLevel = newCurrentHungerLevel <= 100 ? newCurrentHungerLevel : 100;
    }

    public void IncrementCurrentHungerLevel() {
        currentHungerLevel = currentHungerLevel <= 100 ? currentHungerLevel + 1 : 100;
    }

    public void pat() {
        patCount++;
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
        CustomMethods.validatePositiveAndSortedArray(rangeArray, nameOfArray + "_RANGES");
        if (rangeArray[rangeArray.length - 1] > 100) {
            throw new VerifyError(rangeArray + "_RANGES [" + (rangeArray.length - 1) + "] is greater than 100");
        }
    }
}
