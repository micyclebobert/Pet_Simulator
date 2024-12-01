package com.cse215.g2.pet_simulator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SelectionMenu {
    private FullSceenFrame frame;

    public SelectionMenu() {
        setup();
    }

    public void setup() {
        frame = new FullSceenFrame();
        frame.setLayout(null);
        frame.setBackground(Color.BLUE);
        System.out.println("selectionPanel.getBounds() = " + frame.getBounds());
        JLabel text = new JLabel("Select Pet");
        text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        text.setSize(150, 50);
        text.setLocation(20, 20);
        PetSelectionButton cat = new PetSelectionButton("Cat","/Cat.jpg", 100);
        frame.add(cat);
        frame.add(text);
        open();
    }

    public void open() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
        frame.dispose();
    }

}
