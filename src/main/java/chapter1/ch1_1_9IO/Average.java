package chapter1.ch1_1_9IO;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * javac -cp $jarPath chapter1/ch1_1_9IO/Average.java
 * java -cp ${jarPath}:. chapter1.ch1_1_9IO.Average
 * 测试标准输入
 */
public class Average {
    public static void main(String[] args) {
        double sum = 0.0;
        int cnt = 0;
        while (!StdIn.isEmpty()) {
            sum += StdIn.readDouble();
            cnt++;
        }
        double avg = sum / cnt;
        StdOut.printf("Average is %.5f\n", avg);
    }
}
