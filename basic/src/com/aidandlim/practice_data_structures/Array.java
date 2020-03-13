package com.aidandlim.practice_data_structures;

import java.util.Arrays;

public class Array {
    private int[] array;
    private int count;

    // constructor
    public Array(int length) {
        array = new int[length];
    }

    // insert value into first element of array
    // time complexity: O(n)
    public void insertFirst(int value) {
        insertAt(value, 0);
    }

    // insert value into specific index of array
    // time complexity: O(n)
    public void insertAt(int value, int index) {
        if (index >= count) throw new IllegalArgumentException();

        if (isFull()) resize();

        for (int i = count; i > index; i--)
            array[i] = array[i - 1];

        array[index] = value;
        count++;
    }

    // insert value into last element of array
    // time complexity: O(n)
    public void insertLast(int value) {
        if (isFull()) resize();

        array[count++] = value;
    }

    // look up value by index of array
    // time complexity: O(n)
    public int findIndexByValue(int value) {
        for (int i = 0; i < count; i++)
            if (array[i] == value)
                return i;

        return -1;
    }

    // look up index by value of element
    // time complexity: O(1)
    public int findValueByIndex(int index) {
        if (index >= count) throw new IllegalArgumentException();

        return array[index];
    }

    public void removeFirst() {
        removeAt(0);
    }

    // remove value by index of array
    // time complexity: O(n)
    public void removeAt(int index) {
        if (index >= count) throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            array[i] = array[i + 1];

        array[count] = 0;
        count--;
    }

    // remove value of last element
    // time complexity: O(1)
    public void removeLast() {
        if (isEmpty()) return;

        array[count-- - 1] = 0;
    }

    // reverse whole array
    // time complexity: O(n / 2)
    public void reverse() {
        for (int i = 0; i < count / 2; i++) {
            int temp = array[count - 1 - i];
            array[count - 1 - i] = array[i];
            array[i] = temp;
        }
    }

    // look up maximum value in array
    // time complexity: O(n)
    public int max() {
        int max = 0;

        for (int i = 0; i < count; i++)
            if (array[i] > max)
                max = array[i];

        return max;
    }

    // look up minimum value in array
    // time complexity: O(n)
    public int min() {
        int min = 0;

        for (int i = 0; i < count; i++)
            if (array[i] < min)
                min = array[i];

        return min;
    }

    // print whole array
    // time complexity: O(n)
    public void print() {
        System.out.println(Arrays.toString(array));
    }

    // resize array to twice size
    // time complexity: O(n)
    private void resize() {
        int newArray[] = new int[array.length * 2];

        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];

        array = newArray;
    }

    // check whether array is empty
    // time complexity: O(1)
    private boolean isEmpty() {
        return count == 0;
    }

    // check whether array is full
    // time complexity: O(1)
    private boolean isFull() {
        return count == array.length;
    }
}
