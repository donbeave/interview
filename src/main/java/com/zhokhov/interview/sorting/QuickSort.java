/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.mycstutorials.com/articles/sorting/quicksort
 */
package com.zhokhov.interview.sorting;

import static com.zhokhov.interview.util.Console.*;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class QuickSort {

    private int COMPARISONS_COUNT;
    private int SWAPS_COUNT;

    public void sort(int array[]) {
        COMPARISONS_COUNT = 0;
        SWAPS_COUNT = 0;

        quickSort(array, 0, array.length - 1);
    }

    /*
     * The quickSort algorithm implementation
     */
    private void quickSort(int array[], int startIndex, int endIndex) {
        __grey("\nquickSort, startIndex: " + startIndex + ", endIndex: " + endIndex + "  ==> ");
        ____purple("" + (endIndex - startIndex >= 1));

        COMPARISONS_COUNT++;
        // check that there are at least two elements to sort
        // if there is only one element in the partition, do not do any sorting
        if (endIndex - startIndex >= 1) {
            int rightIndex = partition(array, startIndex, endIndex);

            // quicksort the left partition
            quickSort(array, startIndex, rightIndex - 1);

            // quicksort the right partition
            quickSort(array, rightIndex + 1, endIndex);
        }
    }

    private int partition(int array[], int startIndex, int endIndex) {
        // index of left-to-right scan
        int leftIndex = startIndex;

        // index of right-to-left scan
        int rightIndex = endIndex;

        // set the pivot as the first element in the partition
        int pivot = array[startIndex];

        ____grey("pivot: " + pivot);

        // while the scan indices from left and right have not met
        while (rightIndex > leftIndex) {
            COMPARISONS_COUNT++;

            // from the left, look for the first
            // element greater than the pivot
            while (array[leftIndex] <= pivot && leftIndex <= endIndex && rightIndex > leftIndex) {
                COMPARISONS_COUNT++;

                leftIndex++;

                ____blue(" new leftIndex: " + leftIndex);
            }

            // from the right, look for the first
            // element not greater than the pivot
            while (array[rightIndex] > pivot && rightIndex >= startIndex && rightIndex >= leftIndex) {
                COMPARISONS_COUNT++;

                rightIndex--;

                ____blue(" new rightIndex: " + rightIndex);
            }

            COMPARISONS_COUNT++;
            // if the left seekindex is still smaller than
            // the right index, swap the corresponding elements
            if (rightIndex > leftIndex) {
                swap(array, leftIndex, rightIndex);
            }
        }

        // after the indices have crossed, swap the last element in
        // the left partition with the pivot
        swap(array, startIndex, rightIndex);

        return rightIndex;
    }

    private void swap(int array[], int index1, int index2) {
        SWAPS_COUNT++;
        ____blue("Swapping: " + index1 + " and " + index2);

        int temp = array[index1];

        array[index1] = array[index2];
        array[index2] = temp;

        __red("==> ");
        __dump(array);
        System.out.println("");
    }

    public static void main(String[] args) {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 6, 5, 3};

        __yellow("\nNew array: ");
        __dump(array);

        System.out.println("\nSorting");

        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);

        __green("\nResult: ");
        __dump(array);

        ____grey("\nStatistics");
        __green("  Comparisons: ");
        System.out.print(quickSort.COMPARISONS_COUNT);
        __green("\n  Swaps: ");
        System.out.println(quickSort.SWAPS_COUNT);
    }

}
