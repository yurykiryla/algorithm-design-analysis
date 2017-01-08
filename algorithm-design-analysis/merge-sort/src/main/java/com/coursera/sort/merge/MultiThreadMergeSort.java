/**
 * 
 */

package com.coursera.sort.merge;

import com.coursera.sort.Sorting;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Multi threading {@link Sorting} implementation.
 * 
 * @author yuryk
 *
 */
public class MultiThreadMergeSort implements Sorting {

    /**
     * @see com.coursera.sort.Sorting#sort(int[])
     */
    @Override
    public void sort(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        SortTask st = new SortTask(array);
        pool.execute(st);
        st.join();
    }

    private class SortTask extends RecursiveAction {

        /**
         * Eclipse generated.
         */
        private static final long serialVersionUID = 3228977432410940145L;

        private int[] array;

        /**
         * Constructor.
         * @param array int array
         */
        public SortTask(int[] array) {
            super();
            this.array = array;
        }

        /**
         * 
         * @see java.util.concurrent.RecursiveAction#compute()
         */
        @Override
        protected void compute() {
            if (array.length > 1) {
                int firstArrayLength = array.length / 2;
                int[] firstPart = Arrays.copyOfRange(array, 0, firstArrayLength);
                int[] secondPart = Arrays.copyOfRange(array, firstArrayLength, array.length);
                invokeAll(new SortTask(firstPart), new SortTask(secondPart));
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
}
