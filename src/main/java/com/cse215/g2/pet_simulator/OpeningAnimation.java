package com.cse215.g2.pet_simulator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class OpeningAnimation extends Menu {
    FullSceenFrame frame = new FullSceenFrame(false);

    public OpeningAnimation() {
        setup();
    }

    @Override
    void setup() {
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        JLabel title = new JLabel("Pet Simulator");
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 120));
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, Custom.getScreenWidth(), Custom.getScreenHeight());
        frame.add(title);
        frame.setVisible(true);

        long totalAnimationTime = Custom.getNanoSeconds(2);
        long startTime = System.nanoTime();
        long endTime = startTime + totalAnimationTime;
        long difference = endTime - System.nanoTime();
        while (difference > 0) {
            difference = endTime - System.nanoTime();
            long value = difference * 255 / totalAnimationTime;
            if (value < 0)
                break;
            title.setForeground(new Color((int) value, (int) value, (int) value));
            frame.revalidate();
            frame.repaint();
        }
    }

    @Override
    void open() {
    }

    @Override
    void close() {
        frame.dispose();
    }
}
