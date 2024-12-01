package com.cse215.g2.pet_simulator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class SelectionMenu extends Menu {
    private FullSceenFrame frame;

    public SelectionMenu() {
        setup();
    }

    public void setup() {
        frame = new FullSceenFrame();
        JLabel text = new JLabel("About us:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        text.setSize(150, 50);
        text.setLocation(40, 40);
        PetSelectionButton cat = new PetSelectionButton("Cat", "/Cat.jpg", 100, _ -> startGame());
        frame.add(cat);
        frame.add(text);
        open();
    }

    public void startGame() {
        Manager.setPet(Animal.askForNew());
        Manager.setMenu(new GameGUI());
    }

    public void open() {
        frame.setVisible(true);
        Manager.closePrevious();
    }

    public void close() {
        frame.setVisible(false);
        frame.dispose();
    }

}
