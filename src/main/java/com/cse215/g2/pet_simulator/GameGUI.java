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

    public static void addLayerToUI(Component layer, Integer position) {
        layeredPane.add(layer, position);
    }
    // while(current<lastFrameupdatetime)
    // 60 frames per second
    // 1/60 seconds
    // LAyeredPanel: Background, Toys, Pet, UI, Settings
}*/
import javax.swing.*;
import java.awt.*;

public class GameGUI {
    public static final Integer /**/ BACKGROUND_LAYER_POSITION = (Integer) (0);
    public static final Integer /*      */ TOYS_LAYER_POSITION = (Integer) (1);
    public static final Integer /*       */ PET_LAYER_POSITION = (Integer) (2);
    public static final Integer /*        */ UI_LAYER_POSITION = (Integer) (3);
    public static final Integer /*  */ SETTINGS_LAYER_POSITION = (Integer) (4);

    private volatile FullSceenFrame frame;
    private JLayeredPane layeredPane;
    private Animal pet;
    private Thread behaviour = new Thread(new PetBehaviour());
    private Thread loop = new Thread(new GUIUpdateLoop());

    /*
     * TO DO
     * Choose menu JCombobox
     * Chose toys menu
     * Animated health and hunger
     * Eyes?
     * Pet button, buy button, pause, exit
     * custom type specifier like 1f 3l etc
     */
    public GameGUI(Animal pet) {
        this.pet = pet;
        //TODO 
        if(this.pet==null)this.pet= new Animal("A");
        setup();
    }

    public void open() {
        System.out.println("new game");
        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
        frame.repaint();
        loop();
    }

    public void setup() {
        frame = new FullSceenFrame();
        frame.setVisible(true);

        layeredPane = new JLayeredPane();

        layeredPane.setSize(Custom.getScreenSize());

        ImageIcon image1 = Custom.getImageIconFromLocalPath("/Background.jpeg");
        ImageIcon backgroundImage = Custom.getScaledImageIcon("/Background.jpeg", Custom.getScreenWidth(),
                Custom.getScreenHeight(), Image.SCALE_SMOOTH);

        JLabel label1 = new JLabel(image1);
        JLabel backgroundLabel = new JLabel(backgroundImage);

        label1.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        backgroundLabel.setBounds(0, 0, Custom.getScreenWidth(), Custom.getScreenHeight());

        // layeredPane.add(label1, Integer.valueOf(1)); // Lower layer
        layeredPane.add(backgroundLabel, BACKGROUND_LAYER_POSITION); // Higher layer

        JLabel textLabel = new JLabel(pet.getName(), SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        textLabel.setForeground(Color.WHITE);
        textLabel.setBounds(0, 0, Custom.getScreenWidth(), 50);
        layeredPane.add(textLabel, Integer.valueOf(3));

        JButton btn = new JButton("Back");
        btn.setSize(100, 100);
        Custom.setXFromRight(btn, 0);
        btn.addActionListener(e -> close());
        layeredPane.add(btn, UI_LAYER_POSITION);

        JButton headPatButton = new JButton("Head Pat");
        headPatButton.setSize(100, 20);
        Custom.setPercentX(headPatButton, 20);
        Custom.setYFromBottom(headPatButton, 10);
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
        layeredPane.add(feedPetButton, UI_LAYER_POSITION);

        JProgressBar hungerBar = new JProgressBar(0, 100);
        hungerBar.setSize(150, 20);
        Custom.setPercentLocation(hungerBar, 1, 50);
        hungerBar.setString("Hunger");
        hungerBar.setStringPainted(true);
        // healthBar.setBackground(Color.BLACK);
        hungerBar.setForeground(Color.BLUE);
        hungerBar.setValue(0);
        layeredPane.add(hungerBar, UI_LAYER_POSITION);

        JProgressBar happinessBar = new JProgressBar(0, 100);
        happinessBar.setSize(150, 20);
        Custom.setPercentLocation(happinessBar, 1, 55);
        happinessBar.setString("Happiness");
        happinessBar.setStringPainted(true);
        // happinessBar.setBackground(Color.BLACK);
        happinessBar.setForeground(Color.ORANGE);
        happinessBar.setValue(0);
        layeredPane.add(happinessBar, UI_LAYER_POSITION);

        frame.add(layeredPane);
        open();
    }

    private void loop() {
        System.out.println("loop bout to start");
        loop.start();
        behaviour.start();
    }

    public void showLayer(Integer layerPosition) {
        Component[] components = layeredPane.getComponentsInLayer((int) layerPosition);
        for (Component component : components) {
            component.setVisible(true);
        }
    }

    public void hideLayer(Integer layerPosition) {
        Component[] components = layeredPane.getComponentsInLayer((int) layerPosition);
        for (Component component : components) {
            component.setVisible(false);
        }
    }

    public void close() {
        behaviour.interrupt();
        loop.interrupt();
    }

    public void run() {
        // setup();
    }

}
