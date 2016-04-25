package com.queue;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int N;               // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    public Deque() {
        first = null;
        last  = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        last.prev = oldlast;//new
        if (isEmpty()) first = last;
        else {
            oldlast.next = last;
        }
        N++;
    }
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        first.prev = null;//new
        if(isEmpty()) last = first;
        else oldfirst.prev = first;
        N++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first.prev = null;
        first = first.next;
        N--;
        if (isEmpty()) first = null;   // to avoid loitering
        return item;
    }
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;;
        last.next = null;
        last = last.prev;
        N--;
        if (isEmpty()) last = null; // to avoid loitering
        return item;
    }

    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    /**public static void main(String[] args) {
        com.queue.Deque<String> q = new com.queue.Deque<String>();
        q.addFirst("1");
        q.addFirst("2");
        q.addFirst("3");
        q.addFirst("4");
        q.addFirst("5");

        StdOut.println(q.removeFirst());
        StdOut.println(q.removeFirst());
        StdOut.println(q.removeFirst());
        StdOut.println(q.removeFirst());
    }*/
}

