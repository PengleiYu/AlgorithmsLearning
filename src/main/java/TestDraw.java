import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 测试可视化库
 */
public class TestDraw {
    public static void main(String[] args) {
        drawRandomArray();
    }

    /**
     * 绘制函数
     * x、x^2、x*log(x)
     */
    private static void drawFunction() {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 0; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }

    /**
     * 绘制随机生成的数组
     */
    private static void drawRandomArray() {
        int N = 50;
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform();
        }
        /* 排序 */
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = arr[i] / 2.0;
            double rw = 0.5 / N;
            double rh = arr[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }
}
