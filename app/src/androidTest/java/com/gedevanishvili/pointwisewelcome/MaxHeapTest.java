package com.gedevanishvili.pointwisewelcome;

import android.test.InstrumentationTestCase;

import com.gedevanishvili.pointwisewelcome.data.ComparableFactory;
import com.gedevanishvili.pointwisewelcome.data.MaxHeap;
import com.gedevanishvili.pointwisewelcome.data.Tuple;

/**
 * Created by flashin on 1/15/16.
 */
public class MaxHeapTest extends InstrumentationTestCase {

    public void testHeapOperations() {

        MaxHeap Heap = new MaxHeap();

        Heap.add(new Tuple("aaaa", 4));

        String str = ((Tuple) Heap.poll()).getString();
        assertEquals("aaaa", str);

        Tuple Tuple = (Tuple) Heap.poll();
        assertNull(Tuple);

        Heap.add(new Tuple("bbbb", 8));
        Heap.add(new Tuple("cccc", 5));
        Heap.add(new Tuple("dddd", 15));
        Heap.add(new Tuple("eeee", 5));

        str = ((Tuple) Heap.poll()).getString();
        assertEquals("dddd", str);

        Heap.add(new Tuple("ffff", 2));
        Heap.add(new Tuple("gggg", 7));

        str = ((Tuple) Heap.poll()).getString();
        assertEquals("bbbb", str);

        str = ((Tuple) Heap.poll()).getString();
        assertEquals("gggg", str);

        str = ((Tuple) Heap.poll()).getString();
        assertEquals("cccc", str);

        str = ((Tuple) Heap.poll()).getString();
        assertEquals("eeee", str);

    }

    public void testSizeAndCapacity() {

        int N = 100;

        MaxHeap Heap = new MaxHeap();
        for (int i = 1; i <= N; i++) {
            Heap.add(ComparableFactory.getComparable("RandomTuple"));

            int capacity = Heap.getCapacity();
            int size = Heap.size();

            assertEquals(i, size);
            assertTrue(size < capacity);
            assertTrue(2 * size >= capacity);
        }

        for (int i = N; i > 0; i--) {
            Tuple Tuple = (Tuple) Heap.poll();
            assertNotNull(Tuple);

            int capacity = Heap.getCapacity();
            int size = Heap.size();

            assertEquals(i - 1, size);
            assertTrue(size < capacity);
            if (size > 0) {
                assertTrue(4 * size > capacity);
            }
        }
    }
}
