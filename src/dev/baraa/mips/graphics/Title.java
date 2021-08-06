package dev.baraa.mips.graphics;

import javax.swing.*;

public class Title extends JPanel {

    private JLabel lastSaved;
    private JLabel title;

    public Title() {

        this.setOpaque(false);
        this.setLocation(Screen.calculatePoint(460, 90));
        this.setSize(Screen.calculateDimension(1460, 130));
        this.setLayout(null);

        lastSaved = new JLabel("Unsaved");
        lastSaved.setFont(Fonts.getBold().deriveFont(Fonts.fontSize(24)));
        lastSaved.setSize(Screen.calculateDimension(1460,24));
        lastSaved.setLocation(Screen.calculatePoint(0,10));
        lastSaved.setForeground(Colors.SUBGREY.getColor());
        this.add(lastSaved);

        title = new JLabel("Untitled");
        title.setFont(Fonts.getBold().deriveFont(Fonts.fontSize(40)));
        title.setSize(Screen.calculateDimension(1460,40));
        title.setLocation(Screen.calculatePoint(0,80));
        title.setForeground(Colors.BLACK.getColor());
        this.add(title);
    }

    private void updateInfo() {

    }
}
