package chapter1.ch1_3BagQueueStack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 1.3.3
 * 队列的链表实现
 */
public class Queue<Item> implements DataStrctureApi.Queue<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    @Override
    public Item dequeue() {
        Node oldFirst = first;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return oldFirst.item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * 测试用例：
     * 输入: to be or not to - be - - that - - - is
     * 输出：to be not that or be (2 left on stack)
     */
    public static void main(String[] args) {
        DataStrctureApi.Queue<String> stack = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.enqueue(item);
            else if (!stack.isEmpty()) StdOut.print(stack.dequeue() + " ");
        }
        System.out.println(String.format("(%s left on stack)", stack.size()));
    }
}
