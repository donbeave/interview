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

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class ArrayList {

    private static final int SIZE_FACTOR = 5;

    private Object data[];

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
        Object newData[] = new Object[this.size];

        // TODO: System.arraycopy(data, 0, newData, 0, data.length);
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        this.data = newData;

        System.out.println("***index:" + this.index + "size:" + this.size + "data size:" + this.data.length);
    }

    public Object get(int index) throws Exception {
        if (index > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        if (index < 0) {
            throw new Exception("Negative Value");
        }

        return this.data[index];
    }

    public void remove(int removeIndex) throws Exception {
        if (removeIndex > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        }
        if (removeIndex < 0) {
            throw new Exception("Negative Value");
        }
        System.out.println("Object getting removed:" + this.data[removeIndex]);

        for (int i = removeIndex; i < this.data.length - 1; i++) {
            data[i] = data[i + 1];
        }

        this.index--;
    }

    public static void main(String[] args) throws Exception {
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

        System.out.println(mal.get(7));
    }

}