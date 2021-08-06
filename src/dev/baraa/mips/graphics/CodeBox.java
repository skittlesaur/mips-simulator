package dev.baraa.mips.graphics;

import dev.baraa.mips.Simulator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class CodeBox extends JScrollPane {

    private final JTextArea code;

    public CodeBox() {
        this.setSize(Screen.calculateDimension(1050, 715));
        this.setLocation(Screen.calculatePoint(310, 300));
        this.getViewport().setOpaque(true);
        this.setBackground(new Color(0xFCFCFC));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.getVerticalScrollBar().setUI(new dev.baraa.mips.graphics.ScrollBar());
        this.getHorizontalScrollBar().setUI(new dev.baraa.mips.graphics.ScrollBar());

        code = new JTextArea();
        code.setFont(Fonts.getRegular().deriveFont(Fonts.fontSize(35)));
        code.setBackground(new Color(0xFCFCFC));
        code.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Simulator.getSimulator().setSaved(false);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Simulator.getSimulator().setSaved(false);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                Simulator.getSimulator().setSaved(false);
            }
        });

        this.setViewportView(code);
    }

    public String getCode() {
        return code.getText();
    }

    public void reset() {
        code.setText("");
    }

    public void setText(String text) {
        code.setText(text);
    }
}
