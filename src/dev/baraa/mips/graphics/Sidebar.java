package dev.baraa.mips.graphics;

import dev.baraa.mips.Simulator;
import dev.baraa.mips.exceptions.CodeExceptions;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Sidebar extends JPanel {

    public Sidebar() {
        this.setBackground(Colors.GREY.getColor());
        this.setSize(Screen.calculateDimension(160, 1080));
        this.setLayout(null);

        SidebarButton runButton = new SidebarButton("Run", 0, Colors.GREEN);
        runButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                runButton.running();

                ActionListener taskPerformer = evt -> {
                    try {
                        Simulator.getSimulator().runNoPipeline();
                    } catch (CodeExceptions codeExceptions) {
                        System.out.println(codeExceptions.getMessage());
                    }

                    runButton.run();
                };
                Timer timer = new Timer(100, taskPerformer);
                timer.setRepeats(false);
                timer.start();

            }
        });

        SidebarButton newButton = new SidebarButton("New", 1);
        newButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!Simulator.getSimulator().isSaved())
                    if (Simulator.getSimulator().unsavedPopUp("Continue"))
                        try {
                            Simulator.getSimulator().saveFile();
                        } catch (IOException ioException) {
                            System.out.println(" EXCEPTION: " + ioException.getMessage());
                        }
                Simulator.getSimulator().newFile();
            }
        });

        SidebarButton openButton = new SidebarButton("Open", 2);
        openButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("MIPS Program", "txt", "mips"));
                fileChooser.setCurrentDirectory(Simulator.getMainFolder());
                int r = fileChooser.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    try {
                        Simulator.getSimulator().openFile(file);
                    } catch (IOException fileNotFoundException) {
                        System.out.println(" Exception: " + fileNotFoundException.getMessage());
                    }
                }
            }
        });
        SidebarButton saveButton = new SidebarButton("Save", 3);
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Simulator.getSimulator().saveFile();
                } catch (IOException ioException) {
                    System.out.println("Exception: " + ioException.getMessage());
                }
            }
        });
        SidebarButton closeButton = new SidebarButton("Close", 0, 1080 - 160);
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!Simulator.getSimulator().isSaved())
                    if (Simulator.getSimulator().unsavedPopUp("Exit")) try {
                        Simulator.getSimulator().saveFile();
                    } catch (IOException ioException) {
                        System.out.println(" EXCEPTION: " + ioException.getMessage());
                    }
                System.exit(1);
            }
        });

        this.add(runButton);
        this.add(newButton);
        this.add(openButton);
        this.add(saveButton);
        this.add(closeButton);
    }

}
