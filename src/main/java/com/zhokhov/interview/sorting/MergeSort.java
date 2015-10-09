/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.codenlearn.com/2011/10/simple-merge-sort.html
 */
package com.zhokhov.interview.sorting;

import static com.zhokhov.interview.util.Console.__dump;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class MergeSort {

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /*
     * The mergeSort algorithm implementation
     */
    private void mergeSort(int[] array, int left, int right) {

        if (left < right) {

            //split the array into 2
            int center = (left + right) / 2;

            //sort the left and right array
            mergeSort(array, left, center);
            mergeSort(array, center + 1, right);

            //merge the result
            merge(array, left, center + 1, right);
        }
    }

    /*
     * The merge method used by the mergeSort algorithm implementation.
     */
    private void merge(int[] array, int leftArrayBegin,
                       int rightArrayBegin, int rightArrayEnd) {

        int leftArrayEnd = rightArrayBegin - 1;

        int numElements = rightArrayEnd - leftArrayBegin + 1;
        int[] resultArray = new int[numElements];
        int resultArrayBegin = 0;

        // Find the smallest element in both these array and add it to the result
        // array i.e you may have a array of the form [1,5] [2,4]
        // We need to sort the above as [1,2,4,5]
        while (leftArrayBegin <= leftArrayEnd && rightArrayBegin <= rightArrayEnd) {
            if (array[leftArrayBegin] <= array[rightArrayBegin]) {
                resultArray[resultArrayBegin++] = array[leftArrayBegin++];
            } else {
                resultArray[resultArrayBegin++] = array[rightArrayBegin++];
            }
        }

        // After the main loop completed we may have few more elements in
        // left array copy them first
        while (leftArrayBegin <= leftArrayEnd) {
            resultArray[resultArrayBegin++] = array[leftArrayBegin++];
        }

        // After the main loop completed we may have few more elements in
        // right array copy them
        while (rightArrayBegin <= rightArrayEnd) {
            resultArray[resultArrayBegin++] = array[rightArrayBegin++];
        }

        // Copy resultArray back to the main array
        for (int i = numElements - 1; i >= 0; i--, rightArrayEnd--) {
            array[rightArrayEnd] = resultArray[i];
        }
    }

    /*
     * A sample merge method to help understand the merge routine.
     * This below function is not used by the merge sort
     *
     * This is here only for explanation purpose
     */
    public int[] sampleMerge(int[] leftArray, int[] rightArray) {

        int leftArrayEnd = leftArray.length - 1;
        int rightArrayEnd = rightArray.length - 1;
        int leftArrayBegin = 0;
        int rightArrayBegin = 0;

        int numElements = leftArray.length + rightArray.length;
        int[] resultArray = new int[numElements];
        int resultArrayBegin = 0;

        // Find the smallest element in both these array and add it to the temp
        // array i.e you may have a array of the form [1,5] [2,4]
        // We need to sort the above as [1,2,4,5]
        while (leftArrayBegin <= leftArrayEnd && rightArrayBegin <= rightArrayEnd) {
            if (leftArray[leftArrayBegin] <= rightArray[rightArrayBegin]) {
                resultArray[resultArrayBegin++] = leftArray[leftArrayBegin++];
            } else {
                resultArray[resultArrayBegin++] = rightArray[rightArrayBegin++];
            }
        }

        // After the main loop completed we may have few more elements in
        // left array copy them first
        while (leftArrayBegin <= leftArrayEnd) {
            resultArray[resultArrayBegin++] = leftArray[leftArrayBegin++];
        }

        // After the main loop completed we may have few more elements in
        // right array copy them
        while (rightArrayBegin <= rightArrayEnd) {
            resultArray[resultArrayBegin++] = rightArray[rightArrayBegin++];
        }

        return resultArray;
    }

    public static void main(String args[]) {

        System.out.println("Running mergeSort....");
        System.out.println("Running merge sort on..{7, 1, 8, 2, 0, 12, 10, 7, 5, 3}..");
        int array[] = {7, 1, 8, 2, 0, 12, 10, 7, 5, 3};

        MergeSort mergeSort = new MergeSort();

        mergeSort.sort(array);

        __dump(array);

        System.out.println("Now demo a simple merge routine....");
        System.out.println("Merging..{1, 3, 5, 7} and ..{2, 4, 6, 8, 10}..");
        int leftArray[] = {1, 3, 5, 7};
        int rightArray[] = {2, 4, 6, 8, 10};

        int[] mergedArray = mergeSort.sampleMerge(leftArray, rightArray);

        __dump(mergedArray);
    }

}