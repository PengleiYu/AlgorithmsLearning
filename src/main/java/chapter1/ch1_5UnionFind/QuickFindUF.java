package chapter1.ch1_5UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * union-find的quickFind实现
 * find操作复杂度为1，union需要遍历数组将一个分量的所有节点改为另一个分量
 */
public class QuickFindUF {
    private int[] id;//以位置为索引
    private int count;//记录分量总数

    public QuickFindUF(int N) {
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
        return id[p];
    }

    public void union(int p, int q) {//将p和q归并到相同分量中
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;//若p和q已在相同分量中则无需采取任何行动
        for (int i = 0; i < id.length; i++)//将p分量重命名为q的分量
            if (id[i] == pId) id[i] = qId;
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();//读取触点个数
        QuickFindUF uf = new QuickFindUF(N);//初始化N个分量
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();//读取整数对
            if (uf.connected(p, q)) continue;//如果已连通则忽略
            uf.union(p, q);//归并分量
            StdOut.println(uf.count() + "components");
        }
    }
}
