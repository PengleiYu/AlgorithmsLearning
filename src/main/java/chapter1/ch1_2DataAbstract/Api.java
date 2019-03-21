package chapter1.ch1_2DataAbstract;

/**
 * 尝试自己定义api
 */
public interface Api {
    /**
     * 计数器
     */
    interface Counter {
        void increment();

        int tally();

        String toString();
    }

    /**
     * 日期
     */
    interface Date {
        int day();

        int month();

        int year();

        String toString();
    }

    /**
     * 累加器
     */
    interface Accumulator {
        void addDataValue(double val);

        double mean();

        String toString();
    }
}
