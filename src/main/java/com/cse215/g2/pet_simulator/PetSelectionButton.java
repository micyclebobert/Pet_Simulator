package com.cse215.g2.pet_simulator;

import javax.swing.JButton;

public class PetSelectionButton extends JButton {
    public PetSelectionButton(String text, String localPath, int y){
        super(text, Custom.getImageIconFromLocalPath(localPath));
        Custom.xCenter(this, y, Custom.getWidthFromPercent(80), 100);
    }

}
