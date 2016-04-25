import com.queue.Deque;
import com.queue.RandomizedQueue;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.Assert.assertEquals;

public class DequeTest {

    @Test/*Test1 add First 1000 times*/
    public void testSize1000addFirstDeque() throws Exception {
        Deque<Integer> randQueue;
        int size;
        randQueue = new Deque<Integer>();
        for (int i = 0; i < 1000; i++) {
            randQueue.addFirst(i);
        }
        size = randQueue.size();
        assertEquals(1000, size);//Test size enqueue

    }
    @Test/*Test2 add Last 1000 times*/
    public void testSize1000addLastDeque() throws Exception {
        Deque<Integer> randQueue;
        int size;
        //Test1
        randQueue = new Deque<Integer>();
        for (int i = 0; i < 1000; i++) {
            randQueue.addLast(i);
        }
        size = randQueue.size();
        assertEquals(1000, size);//Test size enqueue
    }
    @Test/* Test3 addFirst 1000 removeFirst 1000 times */
    public void testSize1000addFirst1000removeFirstDeqeue() throws Exception {
        Deque<Integer> randQueue;
        int size;
        randQueue = new Deque<Integer>();
        for (int i = 0; i < 1000; i++) {
            randQueue.addFirst(StdRandom.uniform(1,1000));
        }
        for (int i = 0; i < 1000; i++) {
            randQueue.removeFirst();
        }
        size = randQueue.size();
        assertEquals(0, size);
    }
    @Test/* Test4 addFirst 1000 removeLast 1000 times */
    public void testSize1000addFirst1000removeLastDeqeue() throws Exception {
        Deque<Integer> randQueue;
        int size;
        randQueue = new Deque<Integer>();
        for (int i = 0; i < 1000; i++) {
            randQueue.addFirst(StdRandom.uniform(1,1000));
        }
        for (int i = 0; i < 1000; i++) {
            randQueue.removeLast();
        }
        size = randQueue.size();
        assertEquals(0, size);
    }
    @Test/* Test5 addLast 1000 removeLast 1000 times */
    public void testSize1000addLast1000removeLastDeqeue() throws Exception {
        Deque<Integer> randQueue;
        int size;
        randQueue = new Deque<Integer>();
        for (int i = 0; i < 1000; i++) {
            randQueue.addLast(i);
        }
        for (int i = 0; i < 1000; i++) {
            randQueue.removeLast();
        }
        size = randQueue.size();
        assertEquals(0, size);
    }
    @Test/* Test6 addLast 1000 removeFirst 1000 times */
    public void testSize1000addLast1000removeFirstDeqeue() throws Exception {
        Deque<Integer> randQueue;
        int size;
        randQueue = new Deque<Integer>();
        for (int i = 0; i < 1000; i++) {
            randQueue.addLast(StdRandom.uniform(1,1000));
        }
        for (int i = 0; i < 1000; i++) {
            randQueue.removeFirst();
        }
        size = randQueue.size();
        assertEquals(0, size);
    }
    @Test/* Test7 addFirst removeFirst 1000 times */
    public void testSizeEnqueueDeqeue1000Deque() throws Exception {
        Deque<Integer> randQueue;
        int size;
        randQueue = new Deque<Integer>();
        for (int i = 0; i < 10; i++) {
            randQueue.addFirst(StdRandom.uniform(1,1000));
            randQueue.removeFirst();
        }
        size = randQueue.size();
        assertEquals(0, size);
    }
    @Test(expected = NullPointerException.class)/* Test8 addFirst null element*/
    public void testAddFirstNullElementDeque() throws Exception {
        Deque<Integer> randQueue;
        randQueue = new Deque<Integer>();
        randQueue.addFirst(null);
    }
    @Test(expected = NullPointerException.class)/* Test9 addLast null element*/
    public void testAddLastNullElementDeque() throws Exception {
        Deque<Integer> randQueue;
        randQueue = new Deque<Integer>();
        randQueue.addLast(null);
    }
    @Test(expected = NoSuchElementException.class)/* Test10 removeFirst null element*/
    public void testRemoveFirstNullElementDeque() throws Exception {
        Deque<Integer> randQueue;
        randQueue = new Deque<Integer>();
        randQueue.removeFirst();
    }
    @Test(expected = NoSuchElementException.class)/* Test11 removeLast null element*/
    public void testRemoveLastNullElementDeque() throws Exception {
        Deque<Integer> randQueue;
        randQueue = new Deque<Integer>();
        randQueue.removeLast();
    }
}