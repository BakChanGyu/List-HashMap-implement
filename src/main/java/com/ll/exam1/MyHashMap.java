package com.ll.exam1;

public class MyHashMap<K, T> {
    String[] keys;
    T[] values;
    int size = 0;

    public MyHashMap() {
        this.keys = new String[size];
        this.values = (T[]) new Object[size];
    }

    public Object put(String key, T value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return 1;
            }
        }
        size++;
        String[] subKeys = new String[size];
        T[] subValues = (T[]) new Object[size];

        for (int i = 0; i < size; i++) {
            if (i < keys.length) {
                subKeys[i] = keys[i];
                subValues[i] = values[i];
            } else {
                subKeys[i] = key;
                subValues[i] = value;
            }
        }

        keys = subKeys;
        values = subValues;

        return null;
    }

    public int size() {
        return size;
    }

    public Object get(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return 0;
    }

    public Object remove(String key) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }

        size--;
        String[] subKeys = new String[size];
        T[] subValues = (T[]) new Object[size];

        for (int i = 0; i < size; i++) {
            if (i < index) {
                subKeys[i] = keys[i];
                subValues[i] = values[i];
            } else {
                subKeys[i] = keys[i + 1];
                subValues[i] = values[i + 1];
            }
        }

        keys = subKeys;
        values = subValues;


        return 1;
    }

    public boolean containsKey(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(T value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        int originalSize = size;
        for (int i = originalSize - 1; i >= 0; i--) {
            remove(keys[i]);

        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
}
