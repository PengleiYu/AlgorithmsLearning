package chapter1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import utils.DrawUtils;

import java.util.Arrays;

/**
 * 测试可视化库
 */
public class TestDraw {
    public static void main(String[] args) {
//        drawRandomArray();
//        drawFunction();
//        testDraw();
        testSort();
    }

    private static void testDraw() {
        StdDraw.setPenRadius(StdDraw.getPenRadius() * 10);
        StdDraw.point(.3, .5);// 画点
        StdDraw.point(0, .5);
        StdDraw.point(.5, 0);
        StdDraw.setPenRadius();
        StdDraw.line(.2, .4, .8, .9);// 画线

        StdDraw.circle(.5, .5, .4);// 画圆
        StdDraw.square(.5, .5, .4);

        double[] x = {.2, .8, .6, .3};
        double[] y = {.3, .5, .7, .6};
        StdDraw.polygon(x, y);
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
        DrawUtils.drawArray(arr);
        Arrays.sort(arr);
        DrawUtils.drawArray(arr);
    }

    /**
     * 测试绘制排序过程
     */
    private static void testSort() {
        int N = 50;
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform();
        }
        DrawUtils.drawArray(arr);
//        selectionSort(arr);
//        insertionSort(arr);
        shellSort(arr);
    }

    private static void selectionSort(double[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) if (arr[j] < arr[min]) min = j;
            double tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
            DrawUtils.drawArray(arr);
        }
    }

    private static void insertionSort(double[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                double tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                DrawUtils.drawArray(arr);
            }
        }
    }

    private static void shellSort(double[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    double tmp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = tmp;
                    DrawUtils.drawArray(a);
                }
            }
            h = h / 3;
        }
    }
}
