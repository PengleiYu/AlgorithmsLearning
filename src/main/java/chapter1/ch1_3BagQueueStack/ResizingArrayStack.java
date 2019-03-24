package chapter1.ch1_3BagQueueStack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 1.3.2 栈的实现
 * <p>
 * 算法1.1
 * 栈的数组实现
 */
public class ResizingArrayStack<Item> implements DataStrctureApi.Stack<Item> {
    @SuppressWarnings("unchecked")
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    private void resize(int max) {
        @SuppressWarnings("unchecked")
        Item[] temp = (Item[]) new Object[max];
        if (N >= 0) System.arraycopy(a, 0, temp, 0, N);
        a = temp;
    }

    @Override
    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    @Override
    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N < a.length / 4) resize(a.length / 2);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    /**
     * 测试用例：
     * 输入: to be or not to - be - - that - - - is
     * 输出：to be not that or be (2 left on stack)
     */
    public static void main(String[] args) {
        DataStrctureApi.Stack<String> stack = new ResizingArrayStack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        System.out.println(String.format("(%s left on stack)", stack.size()));
    }
}
