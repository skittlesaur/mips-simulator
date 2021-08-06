package dev.baraa.mips.graphics;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Title extends JPanel {

    private final JLabel saved;
    private final JLabel title;

    public Title() {

        this.setOpaque(false);
        this.setLocation(Screen.calculatePoint(460, 90));
        this.setSize(Screen.calculateDimension(1460, 130));
        this.setLayout(null);

        saved = new JLabel("Unsaved");
        saved.setFont(Fonts.getBold().deriveFont(Fonts.fontSize(24)));
        saved.setSize(Screen.calculateDimension(1460, 30));
        saved.setLocation(Screen.calculatePoint(0, 10));
        saved.setForeground(Colors.SUBGREY.getColor());
        this.add(saved);

        title = new JLabel("Untitled");
        title.setFont(Fonts.getBold().deriveFont(Fonts.fontSize(40)));
        title.setSize(Screen.calculateDimension(1460, 50));
        title.setLocation(Screen.calculatePoint(0, 80));
        title.setForeground(Colors.BLACK.getColor());
        this.add(title);
    }

    public void setTitle(String title) {
        this.title.setText(Objects.requireNonNullElse(title, "Untitled"));
    }

    public void setSaved(boolean saved) {
        if (saved)
            this.saved.setText("Saved");
        else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            this.saved.setText("Unsaved Changes (" + dtf.format(now) + ")");
        }
    }

    public void setSaved(String text) {
        saved.setText(text);
    }
}
