package chapter1;

import edu.princeton.cs.algs4.StdRandom;
import graph.Drawable;
import graph.LineDrawable;
import graph.RectDrawable;
import utils.DrawUtils;

import java.awt.*;

public class TestAlgorithmsGraph {
    public static void main(String[] args) throws InterruptedException {
        double[] array = generateArray(100);
        selectionSort(array);
        afterDraw(array);
        array = generateArray(100);
        insertionSort(array);
        afterDraw(array);
        array = generateArray(100);
        shellSort(array);
        afterDraw(array);
    }

    private static void afterDraw(double[] arr) throws InterruptedException {
        DrawUtils.refreshArrayRevers(arr);
        Thread.sleep(1000);
    }

    /**
     * 选择排序
     */
    private static void selectionSort(double[] arr) {
        int N = arr.length;
        LineDrawable lineI = new LineDrawable(Color.RED);
        LineDrawable lineJ = new LineDrawable(Color.BLUE);
        RectDrawable rectI = new RectDrawable(Color.RED);
        RectDrawable rectMin = new RectDrawable(Color.BLUE);
        Drawable[] drawables = {lineI, lineJ, rectI, rectMin};
        for (int i = 0; i < N; i++) {
            int min = i;
            lineI.setPosition(i);
            rectI.setPosition(i);
            for (int j = i + 1; j < N; j++) {
                lineJ.setPosition(j);
                if (arr[j] < arr[min]) min = j;
                rectMin.setPosition(min);
                DrawUtils.drawArray(arr, drawables);
            }
            double tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
            rectI.setPosition(min);
            rectMin.setPosition(i);
            DrawUtils.drawArray(arr, drawables);
        }
    }

    /**
     * 插入排序
     */
    private static void insertionSort(double[] arr) {
        int N = arr.length;
        LineDrawable lineI = new LineDrawable();
        lineI.setPenColor(Color.RED);
        LineDrawable lineJ = new LineDrawable();
        lineJ.setPenColor(Color.BLUE);
        RectDrawable rectSelect = new RectDrawable();
        rectSelect.setPenColor(Color.RED);
        RectDrawable rectOther = new RectDrawable();
        rectOther.setPenColor(Color.BLUE);
        Drawable[] drawables = {lineI, lineJ, rectSelect, rectOther};
        for (int i = 1; i < N; i++) {
            lineI.setPosition(i);
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                lineJ.setPosition(j);
                rectSelect.setPosition(j);
                rectOther.setPosition(j - 1);
                DrawUtils.drawArray(arr, drawables);
                double tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
            }
        }
    }

    /**
     * 希尔排序
     */
    private static void shellSort(double[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        LineDrawable lineSelected = new LineDrawable(Color.RED);
        LineDrawable lineOther = new LineDrawable(Color.BLUE);
        RectDrawable rectI = new RectDrawable(Color.RED);
        RectDrawable rectJ = new RectDrawable(Color.BLUE);
        Drawable[] drawables = {lineSelected, lineOther, rectI, rectJ};
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                rectI.setPosition(i);
//                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                for (int j = i; j >= h; j -= h) {
                    rectJ.setPosition(j);
                    lineSelected.clearPosition();
                    lineOther.clearPosition();
                    if (a[j] < a[j - h]) {
                        double tmp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = tmp;
                        lineSelected.setPosition(j);
                        lineOther.setPosition(j - h);
                    }
                    DrawUtils.drawArray(a, drawables);
                }
            }
            h = h / 3;
        }
    }

    private static double[] generateArray(int num) {
        double[] arr = new double[num];
        for (int i = 0; i < num; i++) {
            arr[i] = StdRandom.uniform();
        }
        DrawUtils.INTERVAL_DRAW = 1000 / num;
        return arr;
    }
}
