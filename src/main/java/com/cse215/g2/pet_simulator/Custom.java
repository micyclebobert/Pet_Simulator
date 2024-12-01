package com.cse215.g2.pet_simulator;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * Common methods used in this project
 */
public class Custom {
    private static Dimension screenSize;

    public static void setScreenSize(Dimension screenSize) {
        System.out.println(screenSize);
        Custom.screenSize = screenSize;
    }

    public static Dimension getScreenSize() {
        System.out.println(screenSize);
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
        comp.setLocation(x, yMiddle(comp.getHeight()));
    }

    public static void xyCenter(JComponent comp) {
        comp.setLocation(xMiddle(comp.getWidth()), yMiddle(comp.getHeight()));
    }

    public static int getWidthFromPercent(int width) {
        return getScreenWidth() * width / 100;
    }

    public static int getHeightFromPercent(int height) {
        return getScreenHeight() * height / 100;
    }

    public static void setPercentWidth(JComponent comp, int width) {
        comp.setSize(getWidthFromPercent(width), comp.getHeight());
    }

    public static void setPercentHeight(JComponent comp, int height) {
        comp.setSize(comp.getWidth(), getHeightFromPercent(height));
    }

    public static void setPercentSize(JComponent comp, int width, int height) {
        // comp.setSize(getScreenWidth() * width / 100, getScreenHeight() * height /
        // 100);
        setPercentWidth(comp, width);
        setPercentHeight(comp, height);
    }

    public static void setX(JComponent comp, int x) {
        comp.setLocation(x, comp.getY());
    }

    public static void setY(JComponent comp, int y) {
        comp.setLocation(comp.getX(), y);
    }

    public static void setXFromRight(JComponent comp, int right) {
        setX(comp, getScreenWidth() - comp.getWidth() - right);
    }

    public static void setYFromBottom(JComponent comp, int bottom) {
        setY(comp, getScreenHeight() - comp.getHeight() - bottom);
    }

    public static void setPercentX(JComponent comp, double percentX) {
        setX(comp, (int) (getScreenWidth() * percentX / 100));
    }

    public static void setPercentY(JComponent comp, double percentY) {
        setY(comp, (int) (getScreenHeight() * percentY / 100));
    }

    public static void setPercentLocation(JComponent comp, double percentX, double percentY) {
        // comp.setLocation((int) (getScreenWidth() * percentX / 100), (int)
        // (getScreenHeight() * percentY / 100));
        setPercentX(comp, percentX);
        setPercentY(comp, percentY);
    }

    public static void setPercentXFromBottom(JComponent comp, double percentRight) {
        setX(comp, (int) ((getScreenWidth() - comp.getHeight()) * percentRight / 100));
    }

    public static void setPercentYFromBottom(JComponent comp, double percentBottom) {
        setY(comp, (int) ((getScreenHeight() - comp.getHeight()) * percentBottom / 100));
    }

    /**
     * @param second
     * @return converts seconds to nano seconds (multiply by 1 000 000 000)
     */
    public static long getNanoSeconds(double second) {
        return (long) (1e9 * second);
    }

    /**
     * @return
     *         Example XY_RANGES is {10, 90}:
     *         return 0 if in between 0 to 10
     *         return 1 if in between 10 to 90
     *         return 2 if above 90+
     */
    public static int getIndexFromRange(int[] array, int comparator) {
        for (int i = 0; i < array.length; i++) {
            if (comparator <= array[i]) {
                return i;
            }
        }
        return array.length - 1;
    }

    public static <T>T getRandom(T[] array) {
        return array[new Random().nextInt(array.length)];
    }

    /**
     * @param localPath
     * @return This method returns the absolute path to the resouces folder/local
     *         path
     */
    public static String getFullPathString(String localPath) {
        return Pet_Simulator.class.getResource(localPath).toString();
    }

    public static URL getFullPathURL(String localPath) {
        return Pet_Simulator.class.getResource(localPath);
    }

    public static ImageIcon getImageIconFromLocalPath(String localPath) {
        return new ImageIcon(getFullPathURL(localPath));
    }

    public static Image getImageFromLocalPath(String localPath) {
        return new ImageIcon(getFullPathURL(localPath)).getImage();
    }

    /**
     * Creates a new {@code Image} object with the specified {@code width} and
     * {@code height} from the given {@code image}
     */
    public static Image getScaledImage(Image image, int width, int height, int processUsing) {
        return image.getScaledInstance(width, height, processUsing);
    }

    /**
     * Creates a new {@code Image} object with the specified {@code width} and
     * {@code height} from the given {@code localPath}
     */
    public static Image getScaledImage(String localPath, int width, int height, int processUsing) {
        return getImageFromLocalPath(localPath).getScaledInstance(width, height, processUsing);
    }

    /**
     * Creates a new {@code Image} object with the specified {@code width} and
     * {@code height} from the given {@code imageIcon}
     */
    public static Image getScaledImage(ImageIcon imageIcon, int width, int height, int processUsing) {
        return getScaledImage(imageIcon.getImage(), width, height, processUsing);
    }

    /**
     * Creates a new {@code ImageIcon} object with the specified {@code width} and
     * {@code height} from the given {@code localPath}
     */
    public static ImageIcon getScaledImageIcon(String localPath, int width, int height, int processUsing) {
        return new ImageIcon(getScaledImage(getImageIconFromLocalPath(localPath), width, height, processUsing));
    }

    /**
     * Creates a new {@code ImageIcon} object with the specified {@code width} and
     * {@code height} from the given {@code imageIcon}
     */
    public static ImageIcon getScaledImageIcon(ImageIcon imageIcon, int width, int height, int processUsing) {
        return new ImageIcon(getScaledImage(imageIcon, width, height, processUsing));
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

    public static void exit() {
        System.exit(0);
    }

    public static void exit(int status) {
        System.exit(status);
    }

}
