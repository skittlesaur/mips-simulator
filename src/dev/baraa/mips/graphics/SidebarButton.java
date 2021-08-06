package dev.baraa.mips.graphics;

import javax.swing.*;

public class SidebarButton extends JButton {

    public SidebarButton(String text) {
        this.setSize(Screen.calculateDimension(160, 120));
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setText(text);
        this.setFont(Fonts.getRegular().deriveFont(Fonts.fontSize(24)));
        this.setForeground(Colors.WHITE.getColor());
    }

    public SidebarButton(String text, int index) {
        this(text);
        this.setLocation(0, Screen.calculateHeight(index * 120));
    }

    public SidebarButton(String text, Colors background) {
        this(text);
        this.setOpaque(true);
        this.setBackground(background.getColor());
    }

    public SidebarButton(String text, int index, Colors background) {
        this(text, index);
        this.setOpaque(true);
        this.setBackground(background.getColor());
    }

    public SidebarButton(String text, int x, int y) {
        this(text);
        this.setLocation(Screen.calculateWidth(x), Screen.calculateHeight(y));
    }
}
