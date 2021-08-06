package dev.baraa.mips;

import dev.baraa.mips.graphics.Fonts;
import dev.baraa.mips.graphics.Window;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Compiler {

    private static boolean saved = false;
    private static Window window;

    public static void main(String[] args) throws IOException, FontFormatException {
        Fonts.initialize();
        window = new Window();
    }

    public static void run() {
        System.out.println("Running Program");
        long startTime = System.currentTimeMillis();

        String[] code = window.getCodeBox().getCode().split("\n");

        for (String line : code) {

        }

        long endTime = System.currentTimeMillis();

        System.out.println("Program Ended: " + (endTime - startTime) + "ms");

    }

    public static void unsavedPopUp() {
        System.out.println("Unsaved Changes");

        Object[] options = {"Save", "Continue"};
        int selection = JOptionPane.showOptionDialog(window, "Would you like to save current file?", "Unsaved Changes",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);

        if (selection == 0)
            saveFile();

    }

    private static void saveFile() {
    }

    public static boolean isSaved() {
        return saved;
    }
}
