package com.gedevanishvili.pointwisewelcome.interfaces;

/**
 * Created by flashin on 1/15/16.
 * This interface contains standard methods while working with Priority Queue
 */
public interface PQ {

    /**
     * removes the first element of the queue and returns it
     * @return returns the first element of the queue, returns null if queue is empty
     */
    public Comparable poll();

    /**
     * adds element into priority queue
     * @param C Comparable Object
     */
    public void add(Comparable C);

    /**
     * gets the size of the queue
     * @return return number of items in the queue
     */
    public int size();
}
