package chapter1.exercise1;

/**
 * 等值键
 */
public class Question29 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 6, 7, 7, 8, 8};
        for (int i = 0; i < 9; i++) {
//            int n = rank(i, arr);
            int n = count(i, arr);
            System.out.println(String.format("%d => %d", i, n));
        }
    }

    /**
     * 查找有序数组arr中和key相等的第一个元素位置
     */
    private static int rank(int key, int[] arr) {
        int rank = Question23_BinarySearch.binarySearch(key, arr);
        while (rank - 1 >= 0 && arr[rank - 1] == key) {
            rank--;
        }
        return rank;
    }

    /**
     * 查找有序数组arr中和key相等的元素数目
     */
    private static int count(int key, int[] arr) {
        int rank = Question23_BinarySearch.binarySearch(key, arr);
        if (rank == -1) return 0;
        int count = 0;
        for (int i = rank; i < arr.length && arr[i] == key; i++)
            count++;
        for (int i = rank - 1; i >= 0 && arr[i] == key; i--)
            count++;
        return count;
    }
}
