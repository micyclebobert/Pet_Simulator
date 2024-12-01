package com.cse215.g2.pet_simulator;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;

public class MainMenu {
    /*
     * private static JButton newGame=new JButton("New Game");
     * private static JButton continueGame=new JButton("Continue Game");
     * private static JButton loadGame=new JButton("Load Game");
     * private static JButton settings=new JButton("Settings");
     */
    private static JFrame frame;
    

    public static void setup() {

        JButton newGame = new JButton("New Game");
        JButton continueGame = new JButton("Continue Game");
        JButton loadGame = new JButton("Load Game");
        JButton settings = new JButton("Settings");
        JButton exit = new JButton("Exit");
        Custom.xCenter(newGame, 500, 100, 30);
        Custom.xCenter(continueGame, 550, 100, 30);
        Custom.xCenter(loadGame, 600, 100, 30);
        Custom.xCenter(settings, 650, 100, 30);
        Custom.xCenter(exit, 700, 100, 30);
        newGame.addActionListener(e -> newGame());
        exit.addActionListener(e->Custom.exit(0));
        frame = new JFrame("Pet Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);// Set the frame to full screen
        frame.setUndecorated(true); // Remove title bar for true full-screen experience
        frame.setBackground(Color.BLACK);
        frame.add(newGame);
        frame.add(exit);
    }
    public static void open(){
        frame.setVisible(true);
    }

    public static void close() {
        // frame.dispose();
        frame.setVisible(false);
    }

    public static void newGame() {
        close();
        GameGUI.open();
    }
}