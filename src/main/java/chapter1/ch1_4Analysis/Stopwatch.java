package chapter1.ch1_4Analysis;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 计时器（实现得很巧妙^_^）
 */
public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    /**
     * 测试用例
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-100_0000, 100_0000);
        Stopwatch stopwatch = new Stopwatch();
        int count = ThreeSum.count(a);
        double time = stopwatch.elapsedTime();
        StdOut.printf("%s triples %s seconds.\n", count, time);
    }
}
