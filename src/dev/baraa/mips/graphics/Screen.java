package dev.baraa.mips.graphics;

import java.awt.*;

public class Screen {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final double width = screenSize.getWidth();
    private static final double height = screenSize.getHeight();

    public static int calculateWidth(int size) {
        return (int) (width * size / 1920.0);
    }

    public static int calculateHeight(int size) {
        return (int) (height * size / 1080.0);
    }

    public static Dimension calculateDimension(int w, int h) {
        return new Dimension(calculateWidth(w), calculateHeight(h));
    }

    public static Point calculatePoint(int w, int h) {
        return new Point(calculateWidth(w), calculateHeight(h));
    }
}
