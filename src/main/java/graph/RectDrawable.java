package graph;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class RectDrawable extends BaseDrawable {
    public RectDrawable() {
    }

    public RectDrawable(Color color) {
        super(color);
    }

    @Override
    void onDraw(double centerX, double centerY, double halfWidth, double halfHeight) {
        StdDraw.filledRectangle(centerX, centerY, halfWidth, halfHeight);
    }
}
