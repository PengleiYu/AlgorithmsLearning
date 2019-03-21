package chapter1.ch1_2DataAbstract;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 尝试自己实现数据结构
 */
public class Impl {
    static class Counter implements Api.Counter {
        private final String name;
        private int count;

        Counter(String id) {
            this.name = id;
        }

        @Override
        public void increment() {
            count++;
        }

        @Override
        public int tally() {
            return count;
        }

        @Override
        public String toString() {
            return count + " " + name;
        }

        public static void main(String[] args) {
            int T = 1000000;
            Counter heads = new Counter("heads");
            Counter tails = new Counter("tails");
            for (int i = 0; i < T; i++)
                if (StdRandom.bernoulli(.5)) heads.increment();
                else tails.increment();
            StdOut.println(heads);
            StdOut.println(tails);
            int d = heads.tally() - tails.tally();
            StdOut.printf("delta=%d, %f%%", Math.abs(d), d * 100.0 / T);
        }
    }

    /**
     * Date的一种实现
     */
    static class Data1 implements Api.Date {
        private final int day;
        private final int month;
        private final int year;

        Data1(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int day() {
            return day;
        }

        @Override
        public int month() {
            return month;
        }

        @Override
        public int year() {
            return year;
        }

        @Override
        public String toString() {
            return month() + "/" + day() + "/" + year();
        }
    }

    /**
     * Date的另一种实现
     */
    static class Date2 implements Api.Date {
        private final int value;

        Date2(int m, int d, int y) {
            value = y * 512 + m * 32 + d;
        }

        @Override
        public int day() {
            return value % 32;
        }

        @Override
        public int month() {
            return (value / 32) % 16;
        }

        @Override
        public int year() {
            return value / 512;
        }

        @Override
        public String toString() {
            return month() + "/" + day() + "/" + year();
        }
    }

    /**
     * 累加器实现
     */
    static class Accumulator1 implements Api.Accumulator {
        private double total;
        private int N;

        @Override
        public void addDataValue(double val) {
            total += val;
            N++;
        }

        @Override
        public double mean() {
            return total / N;
        }

        @Override
        public String toString() {
            return "Mean (" + N + " values): " + String.format("%7.5f", mean());
        }
    }

    /**
     * 累加器可视化实现
     */
    static class VisualAccumulator implements Api.Accumulator {
        private double total;
        private int N;

        public VisualAccumulator(int trials, double max) {
            StdDraw.setXscale(0, trials);
            StdDraw.setYscale(0, max);
            StdDraw.setPenRadius(.005);
        }

        @Override
        public void addDataValue(double val) {
            N++;
            total += val;
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
            StdDraw.point(N, val);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(N, total / N);
        }

        @Override
        public double mean() {
            return total / N;
        }

        @Override
        public String toString() {
            return "Mean (" + N + " values): " + String.format("%7.5f", mean());
        }
    }

    /**
     * 测试累加器
     * javac -cp $jar chapter1/ch1_2DataAbstract/*.java
     * java -cp ${jar}:. chapter1.ch1_2DataAbstract.Impl\$TestAccumator 10000
     */
    static class TestAccumulator {
        public static void main(String[] args) {
            int T = Integer.parseInt(args[0]);
//            Accumulator1 a = new Accumulator1();
            VisualAccumulator a = new VisualAccumulator(T, 1.0);
            for (int i = 0; i < T; i++) {
                a.addDataValue(StdRandom.random());
            }
            StdOut.println(a);
        }
    }
}
