package dev.baraa.mips.graphics;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private static int titlebarHeight;
    private CodeBox codeBox;

    public Window() throws HeadlessException {
        this.setTitle("MIPS Simulator");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Colors.WHITE.getColor());
        titlebarHeight = this.getInsets().top;

        Sidebar sidebar = new Sidebar();
        this.add(sidebar);

        codeBox = new CodeBox();
        this.add(codeBox);

        Title title = new Title();
        this.add(title);

        this.setVisible(true);
    }

    public static int getTitlebarHeight() {
        return titlebarHeight;
    }

    public CodeBox getCodeBox() {
        return codeBox;
    }
}
