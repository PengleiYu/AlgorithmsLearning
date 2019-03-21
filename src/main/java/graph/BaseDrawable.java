package graph;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDrawable implements Drawable {
    private Color penColor = Color.BLUE;
    private List<Integer> positions = new ArrayList<>();
    private int intervalTime = 1000;

    public BaseDrawable() {
    }

    public BaseDrawable(Color color) {
        penColor = color;
    }

    @Override
    public void setDrawInterval(int interval) {
        intervalTime = interval;
    }

    @Override
    public int getDrawInterval() {
        return intervalTime;
    }

    @Override
    public void setPenColor(Color color) {
        penColor = color;
    }

    @Override
    public void addPosition(int position) {
        positions.add(position);
    }

    @Override
    public void setPosition(int position) {
        positions.clear();
        positions.add(position);
    }

    @Override
    public void clearPosition() {
        positions.clear();
    }

    @Override
    public void draw(int position, double centerX, double centerY, double halfWidth, double halfHeight) {
        if (!positions.contains(position)) return;
        StdDraw.setPenColor(penColor);
        onDraw(centerX, centerY, halfWidth, halfHeight);
        StdDraw.setPenColor();
    }

    abstract void onDraw(double centerX, double centerY, double halfWidth, double halfHeight);

}
