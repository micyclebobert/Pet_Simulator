package com.cse215.g2.pet_simulator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GameData implements Serializable {
    private Animal pet;
    private Settings settings;

    public GameData() {
        // pet = new Animal();
        settings = new Settings();
    }

    public Animal getPet() {
        return pet;
    }

    public void saveData() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Custom.getFullPathString("/save.sf"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("error saving");
        }
    }

    public GameData loadData(String path) {
        GameData returnData = new GameData();
        try {
            FileInputStream fileInputStream = new FileInputStream(Custom.getFullPathString(path));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            returnData = (GameData) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return returnData;
        } catch (Exception e) {
            System.out.println("error loading");
        }
        return new GameData();
    }
    /*
     * public static void loadData() {
     * //Settings settings=null;
     * new File(CustomMethods.getFullPathString(""));
     * //Settings s=new Settings();
     * try{
     * Settings s=(Settings)loadObjectFromFile("SettingsValue");
     * } catch(Exception e){
     * e.printStackTrace();
     * 
     * }
     * }
     * public static Object saveData(String localPath) throws Exception {
     * ObjectInputStream objectInputStream=new ObjectInputStream(new
     * FileInputStream(CustomMethods.getFullPathString(localPath)));
     * Object object=objectInputStream.readObject();
     * objectInputStream.close();
     * return object;
     * /*try (ObjectInputStream inFile = new ObjectInputStream(new
     * FileInputStream(path))) {
     * return inFile.readObject();
     * } catch (Exception e) {
     * return null;
     * }
     * }
     */
}