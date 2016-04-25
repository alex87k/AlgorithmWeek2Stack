import com.queue.*;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.*;

import java.util.NoSuchElementException;

import static junit.framework.Assert.*;

public class RandomizedQueueTest {

    @Test/*Test1 enqueue 1000 times*/
    public void testSize1000EnqueueRandomizedQueue() throws Exception {
        RandomizedQueue<Integer> randQueue;
        int size;
        randQueue = new RandomizedQueue<Integer>();
        for (int i = 0; i < 1000; i++) {
            randQueue.enqueue(StdRandom.uniform(1,1000));
        }
        size = randQueue.size();
        assertEquals(1000, size);//Test size enqueue
    }
    @Test/* Test2 enqueue 1000 dequeue 1000 times */
    public void testSize1000EnqueueDeqeueRandomizedQueue() throws Exception {
        RandomizedQueue<Integer> randQueue;
        int size;
        randQueue = new RandomizedQueue<Integer>();
        for (int i = 0; i < 1000; i++) {
            randQueue.enqueue(StdRandom.uniform(1,1000));
        }
        for (int i = 0; i < 1000; i++) {
            randQueue.dequeue();
        }
        size = randQueue.size();
        assertEquals(0, size);//Test size enqueue
    }
    @Test/* Test3 enqueue dequeue 1000 times */
    public void testSizeEnqueueDeqeue1000RandomizedQueue() throws Exception {
        RandomizedQueue<Integer> randQueue;
        int size;
        randQueue = new RandomizedQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            randQueue.enqueue(StdRandom.uniform(1,1000));
            randQueue.dequeue();
        }
        size = randQueue.size();
        assertEquals(0, size);//Test size enqueue
    }
    @Test(expected = NullPointerException.class)/* Test4 enqueue empty element*/
    public void testEnqueEmptyElementRandomizedQueue() throws Exception {
        RandomizedQueue<Integer> randQueue;
        randQueue = new RandomizedQueue<Integer>();
        randQueue.enqueue(null);
    }
    @Test(expected = NoSuchElementException.class)/* Test4 enqueue empty element*/
    public void testDequeEmptyElementRandomizedQueue() throws Exception {
        RandomizedQueue<Integer> randQueue;
        randQueue = new RandomizedQueue<Integer>();
        randQueue.dequeue();
    }
}