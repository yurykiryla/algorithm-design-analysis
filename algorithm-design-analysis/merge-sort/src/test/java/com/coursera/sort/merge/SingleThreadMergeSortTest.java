/**
 * 
 */
package com.coursera.sort.merge;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.coursera.sort.Sorting;

/**
 * @author yuryk
 *
 */
public class SingleThreadMergeSortTest {
    
    private Sorting classUnderTest;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        classUnderTest = new SingleThreadMergeSort();
    }

    /**
     * Test method for {@link com.coursera.sort.merge.SingleThreadMergeSort#sort(int[])}.
     */
    @Test
    public void testSort_Simple() {
        int[] array = new int[] {5, 10, 4, 0};
        classUnderTest.sort(array);
        testArray(array);
    }

    private void testArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }
}
