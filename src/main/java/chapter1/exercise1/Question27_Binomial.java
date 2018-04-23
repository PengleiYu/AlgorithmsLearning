package chapter1.exercise1;

import java.util.Arrays;

/**
 * 伯努利公式
 */
public class Question27_Binomial {
    /**
     * 第二版瞬间计算出来
     */
    public static void main(String[] args) {
        System.out.println(binomial2(100, 50, 0.25));
    }

    /**
     * 测试伯努利公式
     */
    private static void test() {
        int N = 10;
        double p = 0.5;
        for (int i = 0; i <= N; i++) {
            System.out.println(i + "=>" + binomial2(N, i, p));
        }
        System.out.println(binomial2(5, 6, 0.25));
    }

    /**
     * 伯努利公式第一版
     *
     * @param N 实验次数
     * @param k 期望成功次数
     * @param p 每次成功概率
     * @return 每次成功概率为p，N次实验中成功k次的概率
     */
    private static double binomial1(int N, int k, double p) {
        if (N < 0 || k < 0) return 0;
        if (N == 0 && k == 0) return 1;
        return (1 - p) * binomial1(N - 1, k, p) + p * binomial1(N - 1, k - 1, p);
    }

    private static double[][] results = new double[128][128];
    private static double initValue = -1;

    static {
        for (double[] result : results) {
            Arrays.fill(result, initValue);
        }
    }

    /**
     * 伯努利公式第二版；利用数组存储已计算的结果
     *
     * @param N 实验次数
     * @param k 期望成功次数
     * @param p 每次成功概率
     * @return 每次成功概率为p，N次实验中成功k次的概率
     */
    private static double binomial2(int N, int k, double p) {
        if (N < 0 || k < 0) return 0;
        if (N == 0 && k == 0) {
            if (results[N][k] == initValue)
                results[N][k] = 1;
        } else {
            if (results[N][k] == initValue)
                results[N][k] = (1 - p) * binomial2(N - 1, k, p) + p * binomial2(N - 1, k - 1, p);
            // 检查，用于debug
            if (results[N][k] == initValue) System.out.println(String.format("error: N=%d, k=%d", N, k));
        }
        return results[N][k];
    }
}
