package chapter1.exercise1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 使用递归版本的二分查找，并跟踪该方法的调用
 * //todo 考虑用无侵入的代理模式
 */
public class Question23_BinarySearch {
    public static void main(String[] args) {
        int[] whiteList = new In(args[0]).readAllInts();
        Arrays.sort(whiteList);
        while (!StdIn.isEmpty()) {
            System.out.println(binarySearch(StdIn.readInt(), whiteList));
        }
    }

    static int binarySearch(int key, int[] arr) {
        return rank(key, arr, 0, arr.length - 1, 0);
    }

    /**
     * 每次方法被调用时，打印lo和hi，并按照递归深度缩进
     */
    private static int rank(int key, int[] arr, int lo, int hi, int deep) {
        String s = String.format("%d-%d", lo, hi);
        StdOut.printf(String.format("%%%ds\n", deep + s.length()), s);
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (arr[mid] > key) return rank(key, arr, lo, mid - 1, deep + 1);
        else if (arr[mid] < key) return rank(key, arr, mid + 1, hi, deep + 1);
        else return mid;
    }
}
