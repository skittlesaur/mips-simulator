package dev.baraa.mips.graphics;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fonts {

    private static Font regular;
    private static Font bold;

    public static void initialize() throws IOException, FontFormatException {
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        regular = Font.createFont(Font.TRUETYPE_FONT, new File("src/dev/baraa/mips/graphics/fonts/AnonymousPro-Regular.ttf"));
        ge.registerFont(regular);

        bold = Font.createFont(Font.TRUETYPE_FONT, new File("src/dev/baraa/mips/graphics/fonts/AnonymousPro-Bold.ttf"));
        ge.registerFont(bold);
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
