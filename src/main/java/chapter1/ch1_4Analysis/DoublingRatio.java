package chapter1.ch1_4Analysis;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.4.6倍率实验
 * 每次数据量翻倍，同时计算消耗时间倍率变化
 */
public class DoublingRatio {
    public static double timeTrial(int N) {
        int MAX = 100_0000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 250; true; N *= 2) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f %5.1f\n", N, time, time / prev);
            prev = time;
        }
    }
}
