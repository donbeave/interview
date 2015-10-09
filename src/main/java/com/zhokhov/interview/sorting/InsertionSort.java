/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.codenlearn.com/2011/07/simple-insertion-sort.html
 */
package com.zhokhov.interview.sorting;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class InsertionSort {

    public void sort(int array[]) {

        //Ignore the first element [0]
        //start from the element [1] -- Get that element and insert
        for (int index = 1; index < array.length; index++) {
            insert(array, index);
        }
    }

    void insert(int array[], int currentIndex) {

        //value of the element to be inserted
        int value = array[currentIndex];

        //iterate in the loop for all elements below the currentIndex
        int reverseIndex = currentIndex;
        for (int i = currentIndex - 1; i >= 0; i--) {

            //If the array element is  greater than the value
            //move the array element to the next higher index
            if (array[i] >= value) {
                array[i + 1] = array[i];
                reverseIndex = i;
            } else {
                break;
            }
        }
        array[reverseIndex] = value;
    }

    void sampleInsert(int array[], int value) {

        int reverseIndex = array.length - 1;

        //start the loop from last element
        for (int i = array.length - 2; i >= 0; i--) {

            //If the array element is greater than the value
            //move the array element to the next index
            //i.e one level higher on the index.
            if (array[i] >= value) {
                array[i + 1] = array[i];
                reverseIndex = i;
            } else {
                break;
            }
        }

        array[reverseIndex] = value;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int array[] = {7, 1, 8, 2, 0, 12, 10, 7, 5, 3};

        insertionSort.sort(array);

        dumpArray(array);

        System.out.println("***********************");
        int sortedArray[] = {1, 2, 3, 4, 5, 6, Integer.MAX_VALUE};

        insertionSort.sampleInsert(sortedArray, 4);

        dumpArray(sortedArray);
    }

    public static void dumpArray(int[] array) {

        for (int value : array) {
            System.out.println(value);
        }
    }
}
