package com.cse215.g2.pet_simulator;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * Common methods used in this project
 */
public class CustomMethods {
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static int getScreenWidth() {
        return (int) screenSize.getWidth();
    }

    public static int getScreenHeight() {
        return (int) screenSize.getHeight();
    }

    public static int xMiddle(int width) {
        return (getScreenWidth() - width) / 2;
    }

    public static int yMiddle(int height) {
        return (getScreenHeight() - height) / 2;
    }

    public static void xCenter(JComponent comp, int y, int width, int height) {
        comp.setBounds(xMiddle(width), y, width, height);
    }

    public static void yCenter(JComponent comp, int x, int width, int height) {
        comp.setBounds(x, yMiddle(height), width, height);
    }

    public static void xyCenter(JComponent comp, int width, int height) {
        comp.setBounds(xMiddle(width), yMiddle(height), width, height);
    }
    

    public static void xCenter(JComponent comp, int y) {
        comp.setLocation(xMiddle(comp.getWidth()), y);
    }
    public static void yCenter(JComponent comp, int x) {
        comp.setLocation(x,yMiddle(comp.getHeight()));
    }

    public static void xyCenter(JComponent comp) {
        comp.setLocation(xMiddle(comp.getWidth()), yMiddle(comp.getHeight()));
    }
    public static int getIndexFromRange(int[] array, int comparator) {
        for (int i = 0; i < array.length; i++) {
            if (comparator <= array[i]) {
                return i;
            }
        }
        return array.length - 1;
    }

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
     * Makes sure that the {@code array} is sorted and only contains positive
     * integers.
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

    public boolean isArraySortedAndPositive(int[] array, String nameOfArray) {
        if (array[0] <= 0) {
            return false;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIndexInBounds(int[] array, int index) {
        return index < array.length;
    }


    public static <T> boolean isIndexInBounds(T[] array, int index) {
        return index < array.length;
    }

    public static <T> boolean isIndexInBounds(ArrayList<T> array, int index) {
        return index < array.size();
    }

}
