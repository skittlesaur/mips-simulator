package dev.baraa.mips.graphics;

import javax.swing.*;

public class CodeBox extends JScrollPane {

    private JTextArea code;

    public CodeBox() {
        this.setSize(Screen.calculateDimension(1050, 730));
        this.setLocation(Screen.calculatePoint(310, 300));
        this.setOpaque(false);
        this.getViewport().setOpaque(false);
        this.setBorder(null);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.getVerticalScrollBar().setUI(new dev.baraa.mips.graphics.ScrollBar());
        this.getHorizontalScrollBar().setUI(new dev.baraa.mips.graphics.ScrollBar());

        code = new JTextArea("Start typing here");
        code.setFont(Fonts.getRegular().deriveFont(Fonts.fontSize(35)));
        code.setOpaque(false);

        this.setViewportView(code);
    }

    public String getCode() {
        return code.getText();
    }
}
