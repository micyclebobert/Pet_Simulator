package com.cse215.g2.pet_simulator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class GameData implements Serializable {
    private ArrayList<Animal> pets;
    private Animal currentPet;

    public Animal getCurrentPet() {
        return currentPet;
    }

    public void updateAge() {
        for (Animal pet : pets) {
            pet.updateAge();
        }
    }

    public void updateCurrentPet(int index) {
        if (CustomMethods.isIndexInBounds(pets, index)) {
            currentPet = pets.get(index);
        }
    }

    public void adoptNewPet(Animal newPet) {
        pets.add(newPet);
    }

    public void saveData() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(CustomMethods.getFullPathString("/save.sf"));
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
            FileInputStream fileInputStream = new FileInputStream(CustomMethods.getFullPathString(path));
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