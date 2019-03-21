package chapter1.ch1_2DataAbstract;

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
}
