/**
 * 
 */

package com.coursera.sort.merge;

import static org.junit.Assert.assertTrue;

import com.coursera.sort.Sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Test for {@link SingleThreadMergeSort}.
 * 
 * @author yuryk
 *
 */
public class SingleThreadMergeSortTest {

    private Sorting classUnderTest;
    private Random random;

    /**
     * @throws java.lang.Exception excepion
     */
    @Before
    public void setUp() throws Exception {
        classUnderTest = new SingleThreadMergeSort();
        random = new Random();
    }

    /**
     * Test method for {@link com.coursera.sort.merge.SingleThreadMergeSort#sort(int[])}.
     */
    @Test
    public void testSort_Simple() {
        int[] array = new int[] { 5, 10, 4, 0, -1 };
        classUnderTest.sort(array);
        testArray(array);
    }

    /**
     * Test method for {@link com.coursera.sort.merge.SingleThreadMergeSort#sort(int[])}.
     */
    @Test
    public void testSort_Random() {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE / 2;
        }
        classUnderTest.sort(array);
        testArray(array);
    }

    private void testArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }
}
