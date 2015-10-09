/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 */
package com.zhokhov.interview.util;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class Arrays {

    /*
     * Utility for dumping the array
     */
    public static void dump(int[] array) {
        for (int i : array) System.out.print(i + " ");

        System.out.print("\n");
    }

}
