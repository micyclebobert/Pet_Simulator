package com.cse215.g2.pet_simulator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
        frame.add(new CloseButton());
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
        FullSceenFrame selectionPanel = new FullSceenFrame();
        selectionPanel.setLayout(null);
        selectionPanel.setBackground(Color.BLUE);
        selectionPanel.setVisible(true);
        System.out.println("selectionPanel.getBounds() = " + selectionPanel.getBounds());
        JLabel b = new JLabel("Select Pet");
        b.setSize(50, 50);
        b.setLocation(0, 0);
        // frame.removeAll();
        selectionPanel.add(b);
        // close();
        // GameGUI.open();
    }
}