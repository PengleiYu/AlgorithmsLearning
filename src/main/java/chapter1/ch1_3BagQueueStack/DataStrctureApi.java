package chapter1.ch1_3BagQueueStack;

public interface DataStrctureApi {
    interface Bag<Item> extends Iterable<Item> {
        void add(Item item);

        boolean isEmpty();

        int size();
    }

    interface Queue<Item> extends Iterable<Item> {
        void enqueue(Item item);

        Item dequeue();

        boolean isEmpty();

        int size();
    }

    interface Stack<Item> extends Iterable<Item> {
        void push(Item item);

        Item pop();

        boolean isEmpty();

        int size();
    }
}
