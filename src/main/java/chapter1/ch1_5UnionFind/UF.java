package chapter1.ch1_5UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * union-find的标准实现
 * 如果两个数不在同一个分量中，则将其连接
 */
public class UF {
    private int[] id;//以位置为索引
    private int count;//记录分量总数

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        // todo
        return 0;
    }

    public void union(int p, int q) {
        // todo
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();//读取触点个数
        UF uf = new UF(N);//初始化N个分量
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();//读取整数对
            if (uf.connected(p, q)) continue;//如果已连通则忽略
            uf.union(p, q);//归并分量
            StdOut.println(uf.count() + "components");
        }
    }
}
