package chapter1.ch1_4Analysis;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 统计和为0的三int的个数
 * 暴力算法
 * 没有时间统计
 */
public class ThreeSum {
    public static int count(int[] a) {
        int cnt = 0;
        for (int i : a)
            for (int j : a)
                for (int k : a)
                    if (i + j + k == 0)
                        cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new In(args[0]).readAllInts();
        StdOut.println(count(a));
    }
}
