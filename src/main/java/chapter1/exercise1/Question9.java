package chapter1.exercise1;

/**
 * 无符号数N转换为二进制表示
 */
public class Question9 {
    public static void main(String[] args) {
        System.out.println(int2BinaryString(1));
        System.out.println(int2BinaryString(8));
        System.out.println(int2BinaryString(9));
        System.out.println(int2BinaryString(15));
    }

    private static String int2BinaryString(int N) {
        StringBuilder builder = new StringBuilder();
        for (int n = N; n > 0; n /= 2)
            builder.insert(0, (n % 2));
        return builder.toString();
    }
}
