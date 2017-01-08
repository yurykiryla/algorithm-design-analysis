/**
 * 
 */

package com.coursera.sort.merge;

import com.coursera.sort.Sorting;

import java.util.Arrays;

/**
 * Single thread {@link Sorting} implementation.
 * 
 * @author yuryk
 *
 */
public class SingleThreadMergeSort implements Sorting {

    /**
     * @see com.coursera.sort.Sorting#sort(int[])
     */
    @Override
    public void sort(int[] array) {
        if (array.length > 1) {
            int firstArrayLength = array.length / 2;
            int[] firstPart = Arrays.copyOfRange(array, 0, firstArrayLength);
            int[] secondPart = Arrays.copyOfRange(array, firstArrayLength, array.length);
            sort(firstPart);
            sort(secondPart);
            int firstCounter = 0;
            int secondCounter = 0;
            for (int i = 0; i < array.length; i++) {
                if (secondCounter == secondPart.length || (firstCounter != firstPart.length
                        && firstPart[firstCounter] <= secondPart[secondCounter])) {
                    array[i] = firstPart[firstCounter];
                    firstCounter++;
                } else {
                    array[i] = secondPart[secondCounter];
                    secondCounter++;
                }
            }
        }
    }
}
