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

public class GUI {
    static JLayeredPane layeredPane;
    
    public static void start() {
        JFrame frame = new JFrame("Full Screen LayeredPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);// Set the frame to full screen
        frame.setUndecorated(true); // Remove title bar for true full-screen experience

        layeredPane = new JLayeredPane();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        layeredPane.setPreferredSize(screenSize);

        ImageIcon image1 = new ImageIcon(GUI.class.getResource("/test.jpg"));
        ImageIcon backgroundImage = CustomMethods.getScaledImageIcon("/Background.jpeg", screenSize.width, screenSize.height, Image.SCALE_SMOOTH);

        JLabel label1 = new JLabel(image1);
        JLabel backgroundLabel = new JLabel(backgroundImage);

        label1.setBounds(0,0, image1.getIconWidth(), image1.getIconHeight());
        backgroundLabel.setBounds(0, 0, screenSize.width,screenSize.height);

        layeredPane.add(label1, Integer.valueOf(1)); // Lower layer
        layeredPane.add(backgroundLabel, Integer.valueOf(2)); // Higher layer

        JLabel textLabel = new JLabel("Full Screen LayeredPane Example", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        textLabel.setForeground(Color.WHITE);
        textLabel.setBounds(0, 0, screenSize.width, 50);
        //layeredPane.add(textLabel, Integer.valueOf(3));

        frame.add(layeredPane);
        frame.pack();
        frame.setVisible(true);
    }
    private static void animate(){
        
        
    }
    public static void showLayer(Integer layerPosition){
        Component[] components = layeredPane.getComponentsInLayer((int)layerPosition);
        for (Component component : components) {
            component.setVisible(true);
        }
    }
    public static void hideLayer(Integer layerPosition){
        Component[] components = layeredPane.getComponentsInLayer((int)layerPosition);
        for (Component component : components) {
            component.setVisible(false);
        }
    }

}
