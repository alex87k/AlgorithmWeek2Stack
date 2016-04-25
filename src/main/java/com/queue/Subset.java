package com.queue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Subset {
    public static void main(String[] args) {
        Deque<String> q = new Deque<String>();
        int k = Integer.valueOf(args[0]);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            q.addFirst(item);
        }
        while (k > 0) {
            StdOut.println(q.removeLast());
            k--;
        }
        StdOut.println("Hello World");

    }
}