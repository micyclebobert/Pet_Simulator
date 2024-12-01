package com.cse215.g2.pet_simulator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;

public class GameData implements Serializable {
    private Animal pet;
    private static JFileChooser fileChooser = new JFileChooser();

    public GameData() {
    }

    public GameData(Animal pet) {
        this.pet = pet;
    }

    public Animal getPet() {
        return pet;
    }

    public void saveData() {
        try {
            fileChooser.setSelectedFile(new File(pet.getName()+".sf"));//Recommends a name
            fileChooser.showSaveDialog(null);
            FileOutputStream fileOutputStream = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("error saving");
            e.printStackTrace();
        }
    }

    public GameData loadData() {
        try {
            GameData returnData;
            fileChooser.showOpenDialog(null);
            FileInputStream fileInputStream = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            returnData = (GameData) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return returnData;
        } catch (Exception e) {
            System.out.println("error loading");
            e.printStackTrace();
            return new GameData(Animal.askForNew());
        }
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