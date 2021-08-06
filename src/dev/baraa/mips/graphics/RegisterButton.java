package dev.baraa.mips.graphics;

import javax.swing.*;
import java.awt.*;

public class RegisterButton extends JButton {

    private final Color light = new Color(0xE2E2E2);
    private final Color dark = new Color(0x4F5965);

    public RegisterButton(String text) {
        super(text);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
        this.setFont(Fonts.getBold().deriveFont(Fonts.fontSize(30)));
        setInactive();
    }

    public void setInactive() {
        this.setBackground(light);
        this.setForeground(dark);
    }

    public void setActive() {
        this.setBackground(dark);
        this.setForeground(light);
    }
}
