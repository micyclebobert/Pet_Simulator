package com.cse215.g2.pet_simulator;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class CustomMethods {
    public static URL getFullPathURL(String localPath) {
        return Pet_Simulator.class.getResource(localPath);
    }

    public static ImageIcon getImageIconFromLocalPath(String localPath) {
        return new ImageIcon(getFullPathURL(localPath));
    }

    public static Image getImageFromLocalPath(String localPath) {
        return new ImageIcon(getFullPathURL(localPath)).getImage();
    }

    public static Image getScaledImage(Image image, int width, int height, int hint) {
        return image.getScaledInstance(width, height, hint);
    }

    public static Image getScaledImage(String localPath, int width, int height, int hint) {
        return getImageFromLocalPath(localPath).getScaledInstance(width, height, hint);
    }

    public static Image getScaledImage(ImageIcon imageIcon, int width, int height, int hint) {
        return getScaledImage(imageIcon.getImage(), width, height, hint);
    }

    public static ImageIcon getScaledImageIcon(String localPath, int width, int height, int hint) {
        return new ImageIcon(getScaledImage(getImageIconFromLocalPath(localPath), width, height, hint));
    }

    public static ImageIcon getScaledImageIcon(ImageIcon imageIcon, int width, int height, int hint) {
        return new ImageIcon(getScaledImage(imageIcon, width, height, hint));
    }
}
