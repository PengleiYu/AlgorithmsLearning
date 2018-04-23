package chapter1.exercise1;

public class Question25_Euclid {
    /**
     * 第二问：读取命令行参数进行计算
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("必须输入两个数字");
            return;
        }
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        System.out.println(euclid(p, q));
    }

    /**
     * 对欧几里得算法的简单测试
     */
    private static void testEuclid() {
        System.out.println(euclid(9, 3));
        System.out.println(euclid(9, 6));
        System.out.println(euclid(100, 75));
        System.out.println(euclid(99, 91));
    }

    /**
     * 第一问；打印一系列的p、q值
     */
    private static void test1() {
        System.out.println(euclid(105, 24));
    }

    /**
     * 欧几里得算法；亦称辗转相除法
     */
    private static int euclid(int p, int q) {
        int max, min;
        if (p >= q) {
            max = p;
            min = q;
        } else {
            max = q;
            min = p;
        }
        System.out.println("p=" + max + ", q=" + min);
        if (min == 0) return max;
        return euclid(min, max % min);
    }
}
