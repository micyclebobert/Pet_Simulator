package com.cse215.g2.pet_simulator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainMenu  extends Menu {
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

    public void setup() {
        frame = new FullSceenFrame(false);
        JLabel textLabel = new JLabel("Pet Simulator", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 70));
        textLabel.setForeground(Color.WHITE);
        textLabel.setBounds(0, 100, Custom.getScreenWidth(), 200);
        frame.add(textLabel);

        JButton newGameButton = new JButton("New Game");
        JButton loadGameButton = new JButton("Load Game");
        JButton settingsButton = new JButton("Settings");
        JButton aboutUsButton = new JButton("About Us");
        JButton exitButton = new JButton("Exit");
        newGameButton.setSize(100, 30);
        loadGameButton.setSize(100, 30);
        settingsButton.setSize(100, 30);
        aboutUsButton.setSize(100, 30);
        exitButton.setSize(100, 30);
        Custom.setPercentY(newGameButton, 50);
        Custom.setPercentY(loadGameButton, 55);
        Custom.setPercentY(settingsButton, 60);
        Custom.setPercentY(aboutUsButton, 65);
        Custom.setPercentY(exitButton, 70);
        Custom.xCenter(newGameButton);
        Custom.xCenter(loadGameButton);
        Custom.xCenter(settingsButton);
        Custom.xCenter(aboutUsButton);
        Custom.xCenter(exitButton);
        newGameButton.addActionListener(_ -> newGame());
        loadGameButton.addActionListener(_ -> loadGame());
        settingsButton.addActionListener(_ -> openSettings());
        aboutUsButton.addActionListener(_ -> openAboutUs());
        exitButton.addActionListener(_ -> Custom.exit(1));
        frame.add(newGameButton);
        frame.add(loadGameButton);
        frame.add(settingsButton);
        frame.add(aboutUsButton);
        frame.add(exitButton);
        open();
    }

    public void open() {
        Manager.setMenuType(1);
        frame.setVisible(true);
        Manager.closePrevious();
    }

    public void close() {
        Manager.setMenuType(0);
        frame.setVisible(false);
        frame.dispose();
    }

    public void newGame() {
        // close();
        Manager.setMenu(new SelectionMenu());
    }

    public void loadGame() {
        Manager.loadPet();
        // close();
        Manager.setMenu(new GameGUI());
    }

    public void openSettings() {
        // close();
        Manager.setMenu(new SettingsMenu());
    }
    public void openAboutUs(){
        Manager.setMenu(new AboutUsMenu());
    }
}