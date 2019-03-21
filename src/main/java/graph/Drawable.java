package graph;

import java.awt.*;

public interface Drawable {
    void setPenColor(Color color);

    void addPosition(int position);

    void setPosition(int position);

    void clearPosition();

    void draw(int position, double centerX, double centerY, double halfWidth, double halfHeight);

    void setDrawInterval(int interval);

    int getDrawInterval();
}
