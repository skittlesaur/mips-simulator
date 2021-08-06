package dev.baraa.mips.graphics;

import dev.baraa.mips.Compiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sidebar extends JPanel {

    public Sidebar() {
        this.setBackground(Colors.GREY.getColor());
        this.setSize(Screen.calculateDimension(160, 1080));
        this.setLayout(null);

        SidebarButton runButton = new SidebarButton("Run", 0, Colors.GREEN);
        runButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                runButton.setEnabled(false);
                runButton.setBackground(Colors.RED.getColor());

                Compiler.run();

                runButton.setBackground(Colors.GREEN.getColor());
                runButton.setEnabled(true);
            }
        });

        SidebarButton newButton = new SidebarButton("New", 1);
        newButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!Compiler.isSaved())
                    Compiler.unsavedPopUp();

                //TODO: create new file
            }
        });

        SidebarButton openButton = new SidebarButton("Open", 2);
        SidebarButton saveButton = new SidebarButton("Save", 3);
        SidebarButton closeButton = new SidebarButton("Close", 0, 1080 - 160);

        this.add(runButton);
        this.add(newButton);
        this.add(openButton);
        this.add(saveButton);
        this.add(closeButton);
    }

}
