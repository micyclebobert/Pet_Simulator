package com.cse215.g2.pet_simulator;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Common methods used in this project
 */
public class CustomMethods {
    /**
     * @param localPath
     * @return This method returns the absolute path to the resouces folder/local
     *         path
     */
    public static String getFullPathString(String localPath) {
        return Pet_Simulator.class.getResource(localPath).toString();
    }

    public static ImageIcon getImageIconFromLocalPath(String localPath) {
        return new ImageIcon(getFullPathString(localPath));
    }

    public static Image getImageFromLocalPath(String localPath) {
        return new ImageIcon(getFullPathString(localPath)).getImage();
    }

    /**
     * Creates a new {@code Image} object with the specified {@code width} and
     * {@code height} from the given {@code image}
     */
    public static Image getScaledImage(Image image, int width, int height, int hint) {
        return image.getScaledInstance(width, height, hint);
    }

    /**
     * Creates a new {@code Image} object with the specified {@code width} and
     * {@code height} from the given {@code localPath}
     */
    public static Image getScaledImage(String localPath, int width, int height, int hint) {
        return getImageFromLocalPath(localPath).getScaledInstance(width, height, hint);
    }

    /**
     * Creates a new {@code Image} object with the specified {@code width} and
     * {@code height} from the given {@code imageIcon}
     */
    public static Image getScaledImage(ImageIcon imageIcon, int width, int height, int hint) {
        return getScaledImage(imageIcon.getImage(), width, height, hint);
    }

    /**
     * Creates a new {@code ImageIcon} object with the specified {@code width} and
     * {@code height} from the given {@code localPath}
     */
    public static ImageIcon getScaledImageIcon(String localPath, int width, int height, int hint) {
        return new ImageIcon(getScaledImage(getImageIconFromLocalPath(localPath), width, height, hint));
    }

    /**
     * Creates a new {@code ImageIcon} object with the specified {@code width} and
     * {@code height} from the given {@code imageIcon}
     */
    public static ImageIcon getScaledImageIcon(ImageIcon imageIcon, int width, int height, int hint) {
        return new ImageIcon(getScaledImage(imageIcon, width, height, hint));
    }

    /**
     * Makes sure that the {@code array} has only positive values and is sorted.
     */
    public static void validatePositiveAndSortedArray(int[] array, String nameOfArray) {
        if (array[0] <= 0) {
            throw new VerifyError(array + "[0] is not positive");
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                throw new VerifyError(array + "[" + (i - 1) + "] is greater than " + array + "[" + i + "]");
            }
        }
    }

    public static void valdateIndexIsInBounds(int[] array, int index, String nameOfArray) {
        if (index >= array.length)
            throw new VerifyError("index " + index + " is out of bounds for " + nameOfArray + ". " + nameOfArray
                    + " length is " + array.length);
    }

}
