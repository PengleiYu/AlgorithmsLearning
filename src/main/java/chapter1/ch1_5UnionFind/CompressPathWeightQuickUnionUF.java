package chapter1.ch1_5UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 对union-find的加权QuickUnion实现进行路径压缩
 * 结果并不好，很多时候还不如未压缩的
 * 这说明加权quickUnion已经接近极限了
 */
public class CompressPathWeightQuickUnionUF {
    private int[] id;//以位置为索引
    private int[] sz;//(由触点索引的）各个根节点所对应的分量大小
    private int[] tmp;//用于find过程中记录经过的节点
    private int count;//记录分量总数

    public CompressPathWeightQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        tmp = new int[N];//其实用不了N这么多，只是应对最坏情况
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
        int n = 0;
        while (p != id[p]) {
            tmp[n] = p;//记录经过的非根节点
            n++;
            p = id[p];
        }
        for (; n >= 0; n--)
            id[tmp[n]] = p;
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
        CompressPathWeightQuickUnionUF uf = new CompressPathWeightQuickUnionUF(N);//初始化N个分量
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
