package chapter1.ch1_1_9IO;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * javac -cp $jarPath chapter1/ch1_1_9IO/RandomSeq.java
 * java -cp ${jarPath}:. chapter1.ch1_1_9IO.RandomSeq 5 100 200
 * 测试标准输出的格式化
 */
public class RandomSeq {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }
}
