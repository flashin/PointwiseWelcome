package com.gedevanishvili.pointwisewelcome.modules;

import com.gedevanishvili.pointwisewelcome.data.ComparableFactory;
import com.gedevanishvili.pointwisewelcome.data.MaxHeap;
import com.gedevanishvili.pointwisewelcome.interfaces.PQ;

/**
 * Singletone class, stores data in PQ
 * Created by flashin on 1/15/16.
 */
public class PQManager {

    private static PQManager instance = new PQManager();

    private PQ Queue = null;

    private PQManager() {

        Queue = new MaxHeap();
    }

    public static PQManager getInstance() {

        return instance;
    }

    /**
     * adding random item
     */
    public synchronized void add() {

        Queue.add(ComparableFactory.getComparable("RandomTuple"));
    }

    /**
     * thread safe insert int Priority Queue
     *
     * @param C
     */
    public synchronized void add(Comparable C) {

        Queue.add(C);
    }

    /**
     * thread safe get and delete from Priority Queue
     *
     * @return
     */
    public synchronized Comparable poll() {

        return Queue.poll();
    }

    /**
     * thread safe returning of the size of Priority Queue
     * @return
     */
    public synchronized int size(){

        return Queue.size();
    }
}
