package chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * 练习命令行执行
 * java_yu chapter1/BinarySearch tinyW.txt < tinyT.txt
 * 编译和执行时都要通过classpath选项指定依赖库
 */
public class BinarySearch {
    /**
     * 先读取白名单，然后读取key列表，将不在白名单的key打印
     *
     * @param args 白名单
     */
    public static void main(String[] args) {
        int[] whiteList = new In(args[0]).readAllInts();
        Arrays.sort(whiteList);
        // 打印白名单
        System.out.println(Arrays.toString(whiteList));
        while (!StdIn.isEmpty()) {
            // 读取key，若不在白名单则将其打印
            int key = StdIn.readInt();
            if (rank(key, whiteList) < 0)
                System.out.println(key);
        }
    }

    /**
     * 二分查找
     */
    private static int rank(int key, int[] arr) {
//        int lo = 0, hi = arr.length - 1;
//        while (lo <= hi) {
//            int mid = (lo + hi) / 2;
//            if (arr[mid] < key) lo = mid + 1;
//            else if (arr[mid] > key) hi = mid - 1;
//            else return mid;
//        }
//        return -1;
        return rankR(key, arr, 0, arr.length - 1);
    }

    /**
     * 二分查找的递归版本
     */
    private static int rankR(int key, int[] arr, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if (key > arr[mid]) return rankR(key, arr, mid + 1, hi);
        else if (key < arr[mid]) return rankR(key, arr, lo, mid - 1);
        else return mid;
    }
}
