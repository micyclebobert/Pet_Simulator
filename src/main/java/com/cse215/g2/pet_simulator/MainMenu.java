package com.cse215.g2.pet_simulator;


import java.awt.Color;

import javax.swing.JButton;

public class MainMenu {
    /*
     * private static JButton newGame=new JButton("New Game");
     * private static JButton continueGame=new JButton("Continue Game");
     * private static JButton loadGame=new JButton("Load Game");
     * private static JButton settings=new JButton("Settings");
     */
    private FullSceenFrame frame;

    public MainMenu() {
        setup();
    }

    @SuppressWarnings("unused")
    public void setup() {

        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");
        JButton settings = new JButton("Settings");
        JButton exit = new JButton("Exit");
        Custom.xCenter(newGame, 500, 100, 30);
        Custom.xCenter(loadGame, 600, 100, 30);
        Custom.xCenter(settings, 700, 100, 30);
        Custom.xCenter(exit, 800, 100, 30);
        newGame.addActionListener(e -> newGame());
        exit.addActionListener(e -> Custom.exit(0));
        frame = new FullSceenFrame("Pet Simulator");
        frame.setOpacity(1);
        frame.setBackground(Color.BLACK);
        frame.add(newGame);
        frame.add(exit);
        open();
    }

    public void open() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
        frame.dispose();
    }

    public void newGame() {
        close();
        new SelectionMenu();
    }
}