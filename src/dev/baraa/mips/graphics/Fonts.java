package dev.baraa.mips.graphics;

import java.awt.*;
import java.io.IOException;

public class Fonts {

    private static Font regular;
    private static Font bold;

    public void initialize() throws IOException, FontFormatException {
        regular = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("dev/baraa/mips/graphics/fonts/AnonymousPro-Regular.ttf"));
        bold = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("dev/baraa/mips/graphics/fonts/AnonymousPro-Bold.ttf"));
    }

    public static Font getRegular() {
        return regular;
    }

    public static Font getBold() {
        return bold;
    }

    public static float fontSize(int size) {
        return Screen.calculateHeight(size);
    }
}
