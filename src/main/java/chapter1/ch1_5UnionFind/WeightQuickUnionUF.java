package chapter1.ch1_5UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * union-find的加权QuickUnion实现
 */
public class WeightQuickUnionUF {
    private int[] id;//以位置为索引
    private int[] sz;//(由触点索引的）各个根节点所对应的分量大小
    private int count;//记录分量总数

    public WeightQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] > sz[j]) {
            id[j] = i;
            sz[i] += sz[j];
        } else {
            id[i] = j;
            sz[j] += sz[i];
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();//读取触点个数
        WeightQuickUnionUF uf = new WeightQuickUnionUF(N);//初始化N个分量
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
