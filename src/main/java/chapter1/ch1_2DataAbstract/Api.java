package chapter1.ch1_2DataAbstract;

public interface Api {
    /**
     * 计数器
     */
    interface Counter {
        void increment();

        int tally();

        String toString();
    }
}
