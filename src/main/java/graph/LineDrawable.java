package graph;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class LineDrawable extends BaseDrawable {
    public LineDrawable() {
    }

    public LineDrawable(Color color) {
        super(color);
    }

    @Override
    void onDraw(double centerX, double centerY, double halfWidth, double halfHeight) {
        StdDraw.line(centerX, 0, centerX, 1);
    }
}
