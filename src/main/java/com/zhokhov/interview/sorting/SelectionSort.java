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

import static com.zhokhov.interview.util.Console.*;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class SelectionSort {

    private int COMPARISONS_COUNT;
    private int SWAPS_COUNT;
    private int LOOP_COUNT;

    public void sort(int array[]) {
        COMPARISONS_COUNT = 0;
        SWAPS_COUNT = 0;
        LOOP_COUNT = 0;

        // Start from first
        for (int index = 0; index < array.length; index++) {
            LOOP_COUNT++;
            ____cyan("\n--------\nindex: " + index);


            // find the next smallest element
            int minIndex = findNextSmallestElement(index, array);

            ____grey("found smallest element index: " + minIndex);

            SWAPS_COUNT++;
            ____blue("Swapping: " + index + " and " + minIndex);

            // Swap code
            int temp = array[minIndex];

            array[minIndex] = array[index];
            array[index] = temp;

            __red("==> ");
            __dump(array);
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
            LOOP_COUNT++;
            COMPARISONS_COUNT++;
            if (value > array[i]) {
                minIndex = i;
                value = array[minIndex];
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 6, 5, 3};

        __yellow("\nNew array: ");
        __dump(array);

        System.out.println("\nSorting");

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);

        __green("\nResult: ");
        __dump(array);

        ____grey("\nStatistics");
        __green("  Comparisons: ");
        System.out.print(selectionSort.COMPARISONS_COUNT);
        __green("\n  Swaps: ");
        System.out.print(selectionSort.SWAPS_COUNT);
        __green("\n  Loops: ");
        System.out.println(selectionSort.LOOP_COUNT);
    }

}
