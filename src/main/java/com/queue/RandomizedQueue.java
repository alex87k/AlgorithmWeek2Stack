package com.queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;
    private int tail;
    private int head;
    private int N;

    //create an empty q
    public  RandomizedQueue()
    {
        q = (Item[]) new Object[1];
        tail = 0;
        head = 0;
        N = 0;
    }
    //insert a new string into q
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (N == q.length) resizeQueue(q.length * 2);
        if (head == q.length) head = 0;
        q[head++] = item;
        N++;
    }
    //remove and return String
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randValue = 0;
        Item randElement, firstElement;

        if (tail < head) randValue = StdRandom.uniform(tail, head);
        if (tail > head) randValue = StdRandom.uniform(head, tail);
        randElement = q[randValue];
        q[randValue] = q[tail];

        if (N == q.length/4) resizeQueue(q.length/2);
        q[tail++] = null;
        if (tail == q.length) tail = 0;
        N--;
        return randElement;
    }
    //is the q empty?
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    //resize Stack array
    private void resizeQueue(int size) {
        Item[] copy = (Item[]) new Object[size];
        for (int i = 0; i < N; i++) {
            copy[i] = q[(tail + i) % q.length];
        }
        tail = 0;
        head = N;
        q = copy;
    }
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int rand = 0;
        if (tail < head) rand = StdRandom.uniform(tail, head);
        if (tail > head) rand = StdRandom.uniform(head, tail);
        return q[rand];
    }
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private Item[] iteratorArray = (Item[]) new Object[N];
        private int iteratorN = N-1;
        private int i = 0;
        ArrayIterator() {
            for (int j = 0; j < N; j++) {
                iteratorArray[j] = q[(tail + j) % q.length];
            }
        }
        public boolean hasNext()  { return i < N;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item randElement;
            int iteratorRand;
            if (iteratorN != 0)
                iteratorRand = StdRandom.uniform(iteratorN);
            else {
                i++;
                return randElement = iteratorArray[0];
            }
            randElement = iteratorArray[iteratorRand];
            iteratorArray[iteratorRand] = iteratorArray[iteratorN];
            iteratorArray[iteratorN--] = null;
            i++;
            return randElement;
        }
    }
    /**public static void main(String[] args) {
        com.queue.RandomizedQueue<String> q = new com.queue.RandomizedQueue<String>();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        q.enqueue("4");
        q.enqueue("5");

        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
        StdOut.println(q.dequeue());
    }*/
}

