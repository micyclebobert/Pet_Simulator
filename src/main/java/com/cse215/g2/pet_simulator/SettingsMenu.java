package com.cse215.g2.pet_simulator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class SettingsMenu  extends Menu  {

    private FullSceenFrame frame;

    public SettingsMenu() {
        setup();
    }

    public void setup() {
        frame = new FullSceenFrame();
        JLabel text = new JLabel("Settings:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        text.setSize(150, 50);
        text.setLocation(40, 40);
        frame.add(text);
        JLabel selectFPSLabel = new JLabel("Select FPS: ");
        selectFPSLabel.setForeground(Color.WHITE);
        selectFPSLabel.setLocation(90, 140);
        selectFPSLabel.setSize(70,20);
        DropDownSelector selectFPS= new DropDownSelector(Settings.FPS_OPTIONS);
        selectFPS.addItemListener(_->Settings.setIndexOfFPS(selectFPS.getSelectedIndex()));
        selectFPS.setSelectedIndex(Settings.getIndexOfFPS());
        selectFPS.setLocation(180, 140);
        frame.add(selectFPSLabel);
        frame.add(selectFPS);
        JLabel playAudioLabel = new JLabel("Play Audio");
        playAudioLabel.setForeground(Color.WHITE);
        playAudioLabel.setLocation(90, 180);
        playAudioLabel.setSize(70,20);
        JCheckBox playAudio = new JCheckBox();
        playAudio.setLocation(180, 180);
        playAudio.setSize(20,20);
        playAudio.setBackground(null);
        playAudio.setSelected(Settings.getPlayAudio());
        playAudio.addActionListener(_->Settings.setPlayAudio(playAudio.isSelected()));
        frame.add(playAudioLabel);
        frame.add(playAudio);
        open();
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
