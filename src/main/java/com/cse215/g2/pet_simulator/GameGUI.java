package com.cse215.g2.pet_simulator;

/*
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI {

    private static JLayeredPane layeredPane = new JLayeredPane();
    //Image backgroundImage=
//Background Test.jpg
    public static void main(String[] args) {
        ImageIcon image1=new ImageIcon("/test.jpg");
        JLabel l= new JLabel(image1);
        JLabel label1 = new JLabel();

        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setBounds(50, 50, 200, 200);
        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.GREEN);
        label2.setBounds(100, 100, 200, 200);
        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.BLUE);
        label3.setBounds(150, 150, 200, 200);

        layeredPane.setBounds(0, 0, 500, 500);

        // layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(2));
        layeredPane.add(label3, Integer.valueOf(1));
        layeredPane.add(l,(Integer)(3));

        JFrame frame = new JFrame("JLayeredPane");
        //frame.add(layeredPane);
        frame.add(l);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    // while(current<lastFrameupdatetime)
    // 60 frames per second
    // 1/60 seconds
}*/
import javax.swing.*;
import java.awt.*;

public class GameGUI extends Menu {
    public static final Integer /**/ BACKGROUND_LAYER_POSITION = (Integer) (0);
    public static final Integer /*      */ TOYS_LAYER_POSITION = (Integer) (1);
    public static final Integer /*       */ PET_LAYER_POSITION = (Integer) (2);
    public static final Integer /*        */ UI_LAYER_POSITION = (Integer) (3);

    private static FullSceenFrame frame;
    private static JLayeredPane layeredPane;
    private static JProgressBar happinessBar;
    private static JProgressBar hungerBar;
    private static JLabel textLabel;
    private static JLabel physicalLabel;
    private static JLabel mentalLabel;
    public static void setPhysicalLabel(String text) {
        physicalLabel.setText(text);
    }

    public static void setMentalLabel(String text) {
        mentalLabel.setText(text);
    }

    private static Thread behaviour = new Thread(new PetBehaviour());
    private static Thread loop = new Thread(new GUIUpdateLoop());

    public static void setHappiness(int percentage) {
        happinessBar.setValue(percentage);
    }

    public static void setHunger(int percentage) {
        hungerBar.setValue(percentage);
    }

    public static void setTextLabel(String text) {
        textLabel.setText(text);
    }

    /*
     * TO DO
     * Choose menu JCombobox
     * Chose toys menu
     * Animated health and hunger
     * Eyes?
     * Pet button, buy button, pause, exit
     */
    public GameGUI() {
        setup();
    }

    public void setup() {
        frame = new FullSceenFrame();
        frame.setVisible(true);

        layeredPane = new JLayeredPane();

        layeredPane.setSize(Custom.getScreenSize());

        ImageIcon backgroundImage = Custom.getScaledImageIcon("/Background.jpeg", Custom.getScreenWidth(),
                Custom.getScreenHeight(), Image.SCALE_SMOOTH);

        JLabel backgroundLabel = new JLabel(backgroundImage);

        backgroundLabel.setBounds(0, 0, Custom.getScreenWidth(), Custom.getScreenHeight());

        layeredPane.add(backgroundLabel, BACKGROUND_LAYER_POSITION); // Higher layer

        textLabel = new JLabel("", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        textLabel.setForeground(Color.WHITE);
        textLabel.setBounds(0, 0, Custom.getScreenWidth(), 50);
        layeredPane.add(textLabel, UI_LAYER_POSITION);

        // JButton btn = new JButton("Back");
        // btn.setSize(100, 100);
        // Custom.setXFromRight(btn, 0);
        // btn.addActionListener(_ -> close());
        // layeredPane.add(btn, UI_LAYER_POSITION);

        JButton headPatButton = new JButton("Head Pat");
        headPatButton.setSize(100, 20);
        Custom.setPercentX(headPatButton, 20);
        Custom.setYFromBottom(headPatButton, 10);
        headPatButton.addActionListener(_ -> onPat());
        layeredPane.add(headPatButton, UI_LAYER_POSITION);

        JButton buyToysButton = new JButton("Buy Toys");
        buyToysButton.setSize(100, 20);
        Custom.setPercentX(buyToysButton, 40);
        Custom.setYFromBottom(buyToysButton, 10);
        layeredPane.add(buyToysButton, UI_LAYER_POSITION);

        JButton feedPetButton = new JButton("Feed Pet");
        feedPetButton.setSize(100, 20);
        Custom.setPercentX(feedPetButton, 60);
        Custom.setYFromBottom(feedPetButton, 10);
        feedPetButton.addActionListener(_ -> onFeed());
        layeredPane.add(feedPetButton, UI_LAYER_POSITION);

        hungerBar = new JProgressBar(0, 100);
        hungerBar.setSize(150, 20);
        Custom.setPercentLocation(hungerBar, 1, 50);
        hungerBar.setString("Hunger");
        hungerBar.setStringPainted(true);
        hungerBar.setForeground(Color.BLUE);
        hungerBar.setValue(0);
        layeredPane.add(hungerBar, UI_LAYER_POSITION);

        physicalLabel = new JLabel("");
        physicalLabel.setSize(150, 20);
        Custom.setX(physicalLabel, hungerBar.getWidth()+20);
        Custom.setPercentY(physicalLabel, 50);
        physicalLabel.setForeground(new Color(173,  216, 230));
        layeredPane.add(physicalLabel, UI_LAYER_POSITION);

        happinessBar = new JProgressBar(0, 100);
        happinessBar.setSize(150, 20);
        Custom.setPercentLocation(happinessBar, 1, 55);
        happinessBar.setString("Happiness");
        happinessBar.setStringPainted(true);
        happinessBar.setForeground(Color.ORANGE);
        happinessBar.setValue(0);
        layeredPane.add(happinessBar, UI_LAYER_POSITION);

        mentalLabel = new JLabel("");
        mentalLabel.setSize(150, 20);
        Custom.setX(mentalLabel, happinessBar.getWidth()+20);
        Custom.setPercentY(mentalLabel, 55);
        mentalLabel.setForeground(Color.ORANGE);
        layeredPane.add(mentalLabel, UI_LAYER_POSITION);

        frame.add(layeredPane);
        open();
    }

    public void open() {
        frame.setVisible(true);
        Manager.closePrevious();
        Manager.setMenuType(2);
        loop();
    }

    private void loop() {
        loop.start();
        behaviour.start();
    }

    public void onPat() {
        Manager.getPet().pat();
    }

    public void onFeed() {
        Manager.getPet().feed();
    }

    public void close() {
        endThreads();
        Manager.setMenuType(0);
        frame.setVisible(false);
        frame.dispose();
    }
    public static void endThreads(){
        behaviour.interrupt();
        loop.interrupt();}

    public void run() {
        // setup();
    }

}
