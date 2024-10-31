package com.cse215.g2.pet_simulator;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;

public class CustomMethods {
    /**
     * @param localPath
     * @return This method returns the absolute path to the resouces folder/local path
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
     * @param image
     * @param width
     * @param height
     * @param hint
     * @return Scales the image to the given height and width.
     * if hint is Image.SCALE_SMOOTH takes long but gives the best quality
     * if hint is Image.SCALE_FAST its fast but quality is meh
     */
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


    public static void saveObjectToFile(String localPath, Object data) throws Exception{
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(getFullPathString(localPath)));
        objectOutputStream.writeObject(data);
        objectOutputStream.close();
        /*
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(path))) {
            write.writeObject(data);
        } catch (NotSerializableException nse) {
            // do something
        } catch (IOException eio) {
            // Failed to read data
        }*/
    }

    public static void loadSettingsValue() {
        //Settings settings=null;
        new File(getFullPathString("SettingsValue"));
        //Settings s=new Settings();
        try{
            Settings s=(Settings)loadObjectFromFile("SettingsValue");
        } catch(Exception e){
            e.printStackTrace();
            
        }
    }
    public static Object loadObjectFromFile(String localPath) throws Exception {
        ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(getFullPathString(localPath)));
        Object object=objectInputStream.readObject();
        objectInputStream.close();
        return object;
        /*try (ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(path))) {
            return inFile.readObject();
        } catch (Exception e) {
            return null;
        }*/
    }

}
