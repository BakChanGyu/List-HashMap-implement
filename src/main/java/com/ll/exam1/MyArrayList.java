package com.ll.exam1;

public class MyArrayList<T> {
    T[] array;
    int size;

    public MyArrayList() {
        this.array = (T[]) new Object[0];
        this.size = 0;
    }

    public boolean add(T element) {
        size++;
        T[] subArray = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            if (i < array.length) {
                subArray[i] = array[i];
            } else {
                subArray[i] = element;
            }
        }
        array = subArray;

        return true;
    }
    public int size() {
        return size;
    }

    public T get(int index) {
        return array[index];
    }

    public T remove(int index) {
        size--;
        T element = array[index];

        T[] subArray = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            if (i < index) {
                subArray[i] = array[i];
            }
            subArray[i] = array[i + 1];
        }
        array = subArray;

        return element;
    }

    public boolean contains(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int originalSize = size;
        for (int i = originalSize - 1; i >= 0; i--) {
            remove(i);
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
}
