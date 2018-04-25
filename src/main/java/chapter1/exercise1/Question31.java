package chapter1.exercise1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * 随机连接
 *
 * 接受一个int N和double p（0到1）
 * 在圆上画N个点，每对点以概率p连接
 */
public class Question31 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        draw(N, p);
    }

    private static void draw(int N, double p) {
        double centerX = .5, centerY = .5, radius = .4;
        // 画圆
        StdDraw.circle(centerX, centerY, radius);
        StdDraw.setPenRadius(0.05);
        Point2D[] points = new Point2D[N];
        // 圆上画N个点
        for (int i = 0; i < N; i++) {
            double ang = 2 * Math.PI * i / N;
            Point2D point = getPoint(centerX, centerY, radius, ang);
            points[i] = point;
            StdDraw.point(point.x(), point.y());
        }
        StdDraw.setPenRadius();
        StdDraw.setPenColor(Color.GRAY);
        // 对任意两个点连线
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean b = StdRandom.bernoulli(p);
                if (b) StdDraw.line(points[i].x(), points[i].y(), points[j].x(), points[j].y());
            }
        }
    }

    private static Point2D getPoint(double x, double y, double r, double degree) {
        double pX = Math.cos(degree) * r + x;
        double pY = Math.sin(degree) * r + y;
        return new Point2D(pX, pY);
    }
}
