package chapter1.ch1_5UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 对union-find的quickUnion实现进行路径压缩
 */
public class CompressPathQuickUnionUF {
    private int[] id;//以位置为索引
    private int[] tmp;//find时记录经过的路径
    private int count;//记录分量总数

    public CompressPathQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        int n = 0;
        while (p != id[p]) {
            tmp[n] = p;
            n++;
            p = id[p];
        }
        for (; n >= 0; n--)
            id[tmp[n]] = p;
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();//读取触点个数
        CompressPathQuickUnionUF uf = new CompressPathQuickUnionUF(N);//初始化N个分量
        Stopwatch stopwatch = new Stopwatch();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();//读取整数对
            if (uf.connected(p, q)) continue;//如果已连通则忽略
            uf.union(p, q);//归并分量
            StdOut.println(uf.count() + "components");
        }
        StdOut.printf("%s seconds.\n", stopwatch.elapsedTime());
    }
}
