package dev.baraa.mips.graphics;

import dev.baraa.mips.Simulator;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private final CodeBox codeBox;
    private final RegistersData registersData;
    private final Title title;

    public Window() throws HeadlessException {
        this.setTitle("MIPS Simulator");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Colors.WHITE.getColor());
        this.setResizable(false);

        Sidebar sidebar = new Sidebar();
        this.add(sidebar);

        codeBox = new CodeBox();
        this.add(codeBox);

        title = new Title();
        this.add(title);

        registersData = new RegistersData();
        this.add(registersData);

        this.setVisible(true);
    }

    public CodeBox getCodeBox() {
        return codeBox;
    }

    public void updateRegisters() {
        registersData.displayRegisters();
    }

    public void updateTitle(String title) {
        this.title.setTitle(title);
    }

    public void updateTitle() {
        updateTitle(Simulator.getSimulator().getFileName());
    }

    public void updateSaved(boolean saved) {
        title.setSaved(saved);
    }

    public void updateSaved(String text) {
        title.setSaved(text);
    }
}
