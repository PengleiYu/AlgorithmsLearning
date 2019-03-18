package utils;

import edu.princeton.cs.algs4.StdDraw;

public class DrawUtils {
    public static void drawArray(double[] array) {
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        int length = array.length;
        double w = .5 / length;
        for (int i = 0; i < length; i++) {
            double x = 1.0 * i / length;
            double y = array[i] / 2.0;
            StdDraw.filledRectangle(x, y, w, y);
        }
        StdDraw.show();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
