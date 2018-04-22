package chapter1.exercise1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 口算出打印值
 */
public class Question7 {
    public static void main(String[] args) {
        Qb();
    }

    /**
     * 应该是牛顿法；
     * 输出: 3.00009
     */
    private static void Qa() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    /**
     * 计算矩阵的下三角元素个数
     * 输出: 499500
     */
    private static void Qb() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }

    /**
     * 不用说了
     * 结果: 10000
     */
    private static void Qc() {
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        StdOut.println(sum);
    }
}
