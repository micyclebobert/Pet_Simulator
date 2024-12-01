package com.cse215.g2.pet_simulator;

import java.awt.Dimension;
import javax.swing.JComboBox;

public class DropDownSelector extends JComboBox<String> {
    public DropDownSelector(String... args) {
        super(args);
        this.setSize(new Dimension(100, 20));
        this.setSelectedIndex(-1);
    }
    public DropDownSelector(int... args) {
        this(Custom.intArrayToStringArray(args));
    }

    public void addItems(String[] args) {
        for (String string : args) {
            this.addItem(string);
        }
    }
}
