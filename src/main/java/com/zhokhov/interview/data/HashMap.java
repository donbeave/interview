/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.algolist.net/Data_structures/Hash_table/Simple_example
 */
package com.zhokhov.interview.data;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class HashMap {

    private final static int TABLE_SIZE = 128;

    private class HashEntry {

        private int key;
        private int value;

        HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

    }

    HashEntry[] table;

    HashMap() {
        table = new HashEntry[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public int get(int key) {
        int hash = (key % TABLE_SIZE);

        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE);

        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        table[hash] = new HashEntry(key, value);
    }

}
