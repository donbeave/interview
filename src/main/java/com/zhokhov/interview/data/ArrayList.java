/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.journaldev.com/110/how-to-implement-arraylist-with-array-in-java
 */
package com.zhokhov.interview.data;

import java.util.logging.Logger;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */

public class ArrayList {

    private static final int SIZE_FACTOR = 5;

    private static final Logger logger = Logger.getLogger(ArrayList.class.getName());
    private Object[] data;

    private int index;

    private int size;

    public ArrayList() {
        this.data = new Object[SIZE_FACTOR];
        this.size = SIZE_FACTOR;
    }

    public void add(Object item) {
        System.out.println("index:" + this.index + "size:" + this.size + "data size:" + this.data.length);
        if (this.index == this.size - 1) {
            //we need to increase the size of data[]
            increaseSizeAndReallocate();
        }

        data[this.index] = item;
        this.index++;
    }

    private void increaseSizeAndReallocate() {
        this.size = this.size + SIZE_FACTOR;

        // TODO: Arrays.copyOf()
        Object[] newData = new Object[this.size];

        // TODO: System.arraycopy(data, 0, newData, 0, data.length);
        System.arraycopy(data, 0, newData, 0, data.length);

        this.data = newData;

        logger.info("***index:" + this.index + "size:" + this.size + "data size:" + this.data.length);
    }

    public Object get(int index) {
        if (index > this.index - 1) {
            throw new IllegalStateException("ArrayIndexOutOfBound");
        }
        if (index < 0) {
            throw new IllegalStateException("Negative Value");
        }

        return this.data[index];
    }

    public void remove(int removeIndex) {
        if (removeIndex > this.index - 1) {
            throw new IllegalStateException("ArrayIndexOutOfBound");
        }
        if (removeIndex < 0) {
            throw new IllegalStateException("Negative Value");
        }
        logger.fine("Object getting removed: " + this.data[removeIndex]);

        if (this.data.length - 1 - removeIndex >= 0)
            System.arraycopy(data, removeIndex + 1, data, removeIndex, this.data.length - 1 - removeIndex);

        this.index--;
    }

    public static void main(String[] args) {
        ArrayList mal = new ArrayList();
        mal.add("1");
        mal.add("2");
        mal.add("3");
        mal.add("4");
        mal.add("5");
        mal.add("6");
        mal.add("7");
        mal.add("8");
        mal.add("9");
        mal.add("10");

        // remove by index
        mal.remove(5);

        logger.info((String) mal.get(7));
    }

}