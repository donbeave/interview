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

import com.zhokhov.interview.util.Arrays;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class BubbleSort {

    public void sort(int[] array) {
        for (int reverseIndex = array.length - 1; reverseIndex > 1; reverseIndex--) {
            System.out.println("out: " + reverseIndex);

            for (int i = 0; i < reverseIndex; i++) {
                System.out.println("in: " + i);

                if (array[i] > array[i + 1]) {
                    // Swap code
                    int temp = array[i];

                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 6, 5, 3};

        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.sort(array);

        Arrays.dump(array);
    }

}