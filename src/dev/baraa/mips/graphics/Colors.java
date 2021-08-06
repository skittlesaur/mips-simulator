package dev.baraa.mips.graphics;

import java.awt.*;

public enum Colors {
    GREY(0),
    WHITE(1),
    GREEN(2),
    RED(3),
    SUBGREY(4),
    BLACK(5);

    int c;

    Colors(int c) {
        this.c = c;
    }

    public Color getColor() {
        return switch (c) {
            case 0 -> new Color(0x4F5965);
            case 1 -> new Color(0xFFFFFF);
            case 2 -> new Color(0x36CC96);
            case 3 -> new Color(0xEF5151);
            case 4 -> new Color(0x7E8186);
            case 5 -> Color.black;
            default -> null;
        };
    }
}
