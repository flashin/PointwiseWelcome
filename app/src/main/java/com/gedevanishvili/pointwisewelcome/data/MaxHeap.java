package com.gedevanishvili.pointwisewelcome.data;

import com.gedevanishvili.pointwisewelcome.interfaces.PQ;

/**
 * Created by flashin on 1/15/16.
 */
public class MaxHeap implements PQ {

    private Comparable[] arr;
    private int capacity = 2;
    private int N = 0;

    public MaxHeap() {

        arr = new Comparable[capacity];
        arr[0] = null;
    }

    public Comparable poll(){

        if (N == 0){
            return null;
        }
        if (N == 1){
            N--;
            return arr[1];
        }

        Comparable C = arr[1];

        arr[1] = arr[N--];
        sink(1);

        // If there's too many space in the array, resize it
        if (capacity == 4 * N){
            resizeArray(capacity / 2);
        }

        return C;
    }

    public void add(Comparable C) {

        // If there's no space in the array, double its size
        if (N == capacity - 1) {
            resizeArray(2 * capacity);
        }

        arr[++N] = C;
        swim(N);
    }

    public int size(){

        return N;
    }

    /**
     * To check array capacity logic
     * @return the capacity of and heap array
     */
    public int getCapacity(){

        return capacity;
    }

    private void resizeArray(int newCapacity) {

        Comparable[] newArr = new Comparable[newCapacity];
        newArr[0] = null;

        for (int i = 1; i <= N; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
        capacity = newCapacity;
    }

    private void swim(int current) {

        while (current > 1 && arr[current / 2].compareTo(arr[current]) < 0) {
            exchange(current, current / 2);
            current = current / 2;
        }
    }

    private void sink(int current) {

        while (2 * current <= N) {
            int j = 2 * current;
            if (j < N && arr[j].compareTo(arr[j + 1]) < 0) {
                j++;
            }
            if (arr[current].compareTo(arr[j]) >= 0) {
                break;
            }
            exchange(current, j);
            current = j;
        }
    }

    private void exchange(int i, int j) {

        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
