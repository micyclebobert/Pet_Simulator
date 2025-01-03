package com.cse215.g2.pet_simulator;

public class Manager implements Runnable {
    private static int menuType;
    /*
     * 1 == Main Menu
     * 2==Game GUI
     */

    public static int getMenuType() {
        return menuType;
    }

    public static void setMenuType(int menu) {
        Manager.menuType = menu;
    }

    private static Menu menu;
    private static Menu previousMenu = new Menu() {

        @Override
        void setup() {
        }

        @Override
        void open() {
        }

        @Override
        void close() {
        }
    }; //initializing useless value so that it doesn't cause issue later

    public static Menu getMenu() {
        return menu;
    }

    public static void setMenu(Menu menu) {
        previousMenu = menu;
        Manager.menu = menu;
    }

    public static void closePrevious() {
        System.out.println("closed");
        if (previousMenu != null)
            previousMenu.close();
    }

    private static Animal pet;

    public static Animal getPet() {
        return pet;
    }

    public static void setPet(Animal pet) {
        Manager.pet = pet;
    }

    public static void loadPet() {
        setPet(new GameData().loadData().getPet());
    }

    @Override
    public void run() {
        setMenu(new OpeningAnimation());
        setMenu(new MainMenu());
    }

}
