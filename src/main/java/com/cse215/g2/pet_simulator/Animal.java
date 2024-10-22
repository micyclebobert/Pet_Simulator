package com.cse215.g2.pet_simulator;

public class Animal {
    /*
     * States are temporary, Stages are longer term
     */
    int age = 0;
    String[] LIFE_STAGE_NAMES = { "Newborn", "Fledgling", "Prepubesent", "Teenager", "Adult", "Old" };
    int[] LIFE_STAGE_AGE_RANGES = { 2, 4, 8, 12, 20 }; // Range of lifeStages[first] is 0 to lifeStagesAge[first]
    // Range of lifeStages[second] is (lifeStagesAge[first] + 1) to
    // lifeStagesAge[second]
    // Range of lifeStages[last] is (lifeStagesAge[last] + 1) to
    // infinity
    int currentHungerLevel;

    String[] HUNGER_STATE_NAMES = { "Very Hungry", "Hungry", "Well Fed" };
    int[] HUNGER_STATE_RANGES = { 10, 90 };
    int totalSumOfHungerWhenFeeding = 50, countOfFeeding = 1; // Since we agv it I'm giving it a starting value (to
                                                              // avoid division by 0 err)
    String[] PHYSICAL_HEALTH_STAGE_NAMES = { "Malnourished", "Fit", "Overweight" };
    int[] PHYSICAL_HEALTH_STAGE_RANGES = { 10, 90 };
    int toyCount = 0, patCount = 0, sleepCount = 0;
    String[] MENTAL_HEALTH_STAGE_NAMES = { "Sad", "Okay", "Happy" };
    int[] MENTAL_HEALTH_STAGE_RANGES = { 10, 90 };

    int getIndexFromRange(int[] array, int comparator) {
        for (int i = 0; i < array.length; i++) {
            if (comparator <= array[i]) {
                return i;
            }
        }
        return array.length - 1;
    }

    public int getCurrentLifeStageIndex() {
        return getIndexFromRange(LIFE_STAGE_AGE_RANGES, age);
    }

    public String getCurrentLifeStageName() {
        return LIFE_STAGE_NAMES[getCurrentLifeStageIndex()];
    }

    public int getCurrentHungerStateIndex() {
        return getIndexFromRange(HUNGER_STATE_RANGES, currentHungerLevel);
    }

    public String getCurrentHungerStateName() {
        return HUNGER_STATE_NAMES[getCurrentHungerStateIndex()];
    }

    public int getCurrentPhysicalHealthStageIndex() {
        int avg = totalSumOfHungerWhenFeeding / countOfFeeding;
        return getIndexFromRange(PHYSICAL_HEALTH_STAGE_RANGES, avg);
    }

    public String getCurrentPhysicalHealthStageName() {
        return PHYSICAL_HEALTH_STAGE_NAMES[getCurrentPhysicalHealthStageIndex()];
    }

    public int getCurrentMentalHealthStageIndex() {
        int min = Math.min(toyCount, Math.min(patCount, sleepCount));
        return getIndexFromRange(MENTAL_HEALTH_STAGE_RANGES, min);
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

    public  void Validate() {
        validateArray(LIFE_STAGE_NAMES, LIFE_STAGE_AGE_RANGES, "LIFE_STAGE");
        validateArray(HUNGER_STATE_NAMES, HUNGER_STATE_RANGES, "HUNGER_STATE");
        validateArray(PHYSICAL_HEALTH_STAGE_NAMES, PHYSICAL_HEALTH_STAGE_RANGES, "PHYSICAL_HEALTH");
        validateArray(MENTAL_HEALTH_STAGE_NAMES, MENTAL_HEALTH_STAGE_RANGES, "MENTAL_HEALTH");
    }

    void validateArray(String[] nameArray, int[] rangeArray, String nameOfArray) {
        validateNameAndRangeLengths(nameArray, rangeArray, nameOfArray);
        validateRangeArray(rangeArray, nameOfArray);
    }

    void validateNameAndRangeLengths(String[] nameArray, int[] rangeArray, String nameOfArray) {
        if (nameArray.length - 1 != rangeArray.length) {
            throw new VerifyError(nameOfArray + "_Names length - 1 does not equal " + nameOfArray + "_Ranges length");
        }
    }

    void validateRangeArray(int[] rangeArray, String nameOfArray) {
        if (rangeArray[0] < 0) {
            throw new VerifyError(rangeArray + "_Ranges[0] is negative");
        }
        for (int i = 1; i < rangeArray.length; i++) {
            if (rangeArray[i - 1] > rangeArray[i]) {
                throw new VerifyError(
                    rangeArray + "_Ranges[" + (i - 1) + "] is greater than " + rangeArray + "_Ranges[" + i + "]");
                }
            }
        if (rangeArray[rangeArray.length - 1] > 100) {
            throw new VerifyError(rangeArray + "_Ranges[" + (rangeArray.length - 1) + "] is greater than 100");
        }
    }
}
