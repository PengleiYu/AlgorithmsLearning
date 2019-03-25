package chapter1.ch1_4Analysis;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.4.2.3 实验数据的分析
 * <p>
 * 对{@link ThreeSum#count(int[])}进行测试，每次数据量翻倍
 */
public class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 100_0000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for (int N = 250; true; N *= 2) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
