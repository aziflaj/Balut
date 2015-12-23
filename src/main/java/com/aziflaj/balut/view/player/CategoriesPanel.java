package com.aziflaj.balut.view.player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CategoriesPanel extends JPanel {

    static final String[] UPPER_CATEGORIES = {
            "Ones", "Twos", "Threes",
            "Fours", "Fives", "Sixes" };

    static final String[] LOWER_CATEGORIES = {
            "Three of a Kind", "Four of a Kind", "Full House (25)",
            "Four Stair (30)", "Five Stair (40)", "Five of a Kind (50)", "Any Other"
    };

    public CategoriesPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // create the title label
        JLabel title = new JLabel("Game Category");
        this.add(title);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // create the upper categories
        for (String cat : UPPER_CATEGORIES) {
            JLabel label = new JLabel(cat);
            this.add(label);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setBorder(new EmptyBorder(5, 0, 5, 0));
        }

        JLabel upperPointsLabel = new JLabel("Upper Points");
        this.add(upperPointsLabel);
        upperPointsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        upperPointsLabel.setBorder(new EmptyBorder(5, 0, 5, 0));

        JLabel bonusLabel = new JLabel("Bonus (35)");
        this.add(bonusLabel);
        bonusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bonusLabel.setBorder(new EmptyBorder(5, 0, 5, 0));

        // create the lower categories
        for (String cat : LOWER_CATEGORIES) {
            JLabel label = new JLabel(cat);
            this.add(label);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label.setBorder(new EmptyBorder(5, 0, 5, 0));
        }

        JLabel lowerPointsLabel = new JLabel("Lower Points");
        this.add(lowerPointsLabel);
        lowerPointsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lowerPointsLabel.setBorder(new EmptyBorder(5, 0, 5, 0));

        JLabel totalLabel = new JLabel("TOTAL");
        this.add(totalLabel);
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalLabel.setBorder(new EmptyBorder(5, 0, 5, 0));
    }
}
