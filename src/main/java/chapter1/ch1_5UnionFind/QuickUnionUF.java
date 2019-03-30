package chapter1.ch1_5UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * union-find的quickUnion实现
 * 使用树结构，union复杂度为1，find需要从节点遍历到根
 */
public class QuickUnionUF {
    private int[] id;//以位置为索引
    private int count;//记录分量总数

    public QuickUnionUF(int N) {
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
        while (p != id[p]) p = id[p];
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
        QuickUnionUF uf = new QuickUnionUF(N);//初始化N个分量
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();//读取整数对
            if (uf.connected(p, q)) continue;//如果已连通则忽略
            uf.union(p, q);//归并分量
            StdOut.println(uf.count() + "components");
        }
    }
}
