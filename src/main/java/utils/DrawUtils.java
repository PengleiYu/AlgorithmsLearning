package utils;

import edu.princeton.cs.algs4.StdDraw;
import graph.Drawable;
import graph.RectDrawable;

import java.awt.*;

public class DrawUtils {
    public static int INTERVAL_DRAW = 1000;

    public static void drawArray(double[] arr, Drawable... drawables) {
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        int length = arr.length;
        double w = .5 / length;
        for (int i = 0; i < length; i++) {
            double centerX = 1.0 * i / length + w;
            double centerY = arr[i] / 2.0;
            StdDraw.filledRectangle(centerX, centerY, w, centerY);
            for (Drawable drawable : drawables) drawable.draw(i, centerX, centerY, w, centerY);
        }
        StdDraw.show();
        try {
            Thread.sleep(INTERVAL_DRAW);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void refreshArrayRevers(double[] arr) {
        Drawable drawable = new RectDrawable(Color.GREEN);
        for (int i = 0, len = arr.length; i <= len; i++) {
            drawable.setPosition(i);
            drawArray(arr, drawable);
        }
    }
}
