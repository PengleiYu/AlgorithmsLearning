package chapter1.ch1_3BagQueueStack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 1.3.3
 * 算法1.2 栈的链表实现
 */
public class Stack<Item> implements DataStrctureApi.Stack<Item> {
    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Item pop() {
        Node oldFirst = first;
        first = first.next;
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
        DataStrctureApi.Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        System.out.println(String.format("(%s left on stack)", stack.size()));
    }
}
