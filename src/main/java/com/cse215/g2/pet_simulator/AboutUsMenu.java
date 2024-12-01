package com.cse215.g2.pet_simulator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class AboutUsMenu extends Menu {

    private FullSceenFrame frame;

    public AboutUsMenu() {
        setup();
    }

    public void setup() {
        frame = new FullSceenFrame();
        frame = new FullSceenFrame();
        JLabel text = new JLabel("About us:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        text.setSize(150, 50);
        text.setLocation(40, 40);
        frame.add(text);
        TextDisplay textDisplay = new TextDisplay(
                "\tGithub: https://github.com/micyclebobert/Pet_Simulator\n" + //
                        "\n" + //
                        "\tMemebers: \n" + //
                        "\t\tAoutul Nabi Purna\taoutul.purna.241@northsouth.edu\n" + //
                        "\t\tShishir Dhar      \tshishir.dhar.241@northsouth.edu\n" + //
                        "\t\tThauhid Ferdhous\tthauhid.ferdhous.241@northsouth.edu\n" + //
                        "\t\tMd. Rahat Sarkar\trahat.sarkar.241@northsouth.edu\n" + //
                        "\n" + //
                        "\tDepartment of Computer Science and Engineering, North South University\n" + //
                        "\tPlot#15, Block-B, Bashundhara R/A, Baridhara, Dhaka-1229, Bangladesh\n" //
        );
        textDisplay.setFont(new Font("Arial", Font.PLAIN, 18));
        textDisplay.setForeground(Color.WHITE);
        Custom.setPercentSize(textDisplay, 75, 75);
        Custom.setPercentLocation(textDisplay, 25, 25);
        frame.add(textDisplay);
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
