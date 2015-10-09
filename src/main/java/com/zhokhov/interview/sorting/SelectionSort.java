/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.codenlearn.com/2011/07/simple-selection-sort.html
 */
package com.zhokhov.interview.sorting;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class SelectionSort {

    public void sort(int array[]) {

        //Start from first
        for (int index = 0; index < array.length; index++) {

            //find the next smallest element
            int minIndex = findNextSmallestElement(index, array);

            // Swap code
            int temp = array[minIndex];
            array[minIndex] = array[index];
            array[index] = temp;
        }
    }

    /*
     * Finds the smallest element starting startIndex
     *
     * @ returns the index of the smallest element.
     */
    private int findNextSmallestElement(int startIndex, int array[]) {

        int minIndex = startIndex;

        int value = array[startIndex];

        for (int i = startIndex; i < array.length; i++) {
            if (value > array[i]) {
                minIndex = i;
                value = array[minIndex];
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {

        int array[] = {7, 1, 8, 2, 0, 12, 10, 6, 5, 3};

        SelectionSort selectionSort = new SelectionSort();

        selectionSort.sort(array);

        dumpArray(array);
    }

    public static void dumpArray(int[] array) {

        for (int value : array) {
            System.out.println(value);
        }
    }
}
