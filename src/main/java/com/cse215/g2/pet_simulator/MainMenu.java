package com.cse215.g2.pet_simulator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Button;
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
    private JPanel buttonPanel;


    public MainMenu() {


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
        open();
    }
    public void open(){
        frame.setVisible(true);
    }

    public void close() {
        // frame.dispose();
        frame.setVisible(false);
    }

    public void newGame() {
        JPanel selectionPanel=new JPanel();
        selectionPanel.setLayout(null);
        Custom.setPercentSize(selectionPanel, 50, 50);
        Custom.xyCenter(selectionPanel);
        selectionPanel.setBackground(Color.BLUE);
        selectionPanel.setOpaque(true);
        selectionPanel.setVisible(true);
        System.out.println("selectionPanel.getBounds() = " + selectionPanel.getBounds());
        JLabel b = new JLabel("Select Pet");
        b.setSize(50,50);
        b.setLocation(0, 0);
        // frame.removeAll();
        selectionPanel.add(b);
        frame.add(selectionPanel);
        frame.revalidate();
        frame.repaint();
        // close();
        // GameGUI.open();
    }
}