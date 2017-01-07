/**
 * 
 */

package com.coursera;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 * {@link KaratsubaMultiplicationImpl} test.
 * 
 * @author yuryk
 *
 */
public class KaratsubaMultiplicationImplTest {

    /**
     * {@link KaratsubaMultiplication} instance.
     */
    private KaratsubaMultiplication classUnderTest;

    /**
     * Initialization.
     * 
     * @throws java.lang.Exception
     *             in case of any exception
     */
    @Before
    public void setUp() throws Exception {
        classUnderTest = new KaratsubaMultiplicationImpl();
    }

    /**
     * Test method for
     * {@link KaratsubaMultiplicationImpl#multiply(BigInteger, BigInteger)}.
     */
    @Test
    public void testMultiply_simple() {
        BigInteger x = BigInteger.valueOf(8);
        BigInteger y = BigInteger.valueOf(5);
        assertEquals(x.multiply(y), classUnderTest.multiply(x, y));
    }

    /**
     * Test method for
     * {@link KaratsubaMultiplicationImpl#multiply(BigInteger, BigInteger)}.
     */
    @Test
    public void testMultiply_complex() {
        BigInteger x = BigInteger.valueOf(5678);
        BigInteger y = BigInteger.valueOf(1234);
        assertEquals(x.multiply(y), classUnderTest.multiply(x, y));
    }

    /**
     * Test method for
     * {@link KaratsubaMultiplicationImpl#multiply(BigInteger, BigInteger)}.
     */
    @Test
    public void testMultiply_complex_one_minus() {
        BigInteger x = BigInteger.valueOf(-5678);
        BigInteger y = BigInteger.valueOf(1234);
        assertEquals(x.multiply(y), classUnderTest.multiply(x, y));
    }

    /**
     * Test method for
     * {@link KaratsubaMultiplicationImpl#multiply(BigInteger, BigInteger)}.
     */
    @Test
    public void testMultiply_complex_two_minus() {
        BigInteger x = BigInteger.valueOf(-5678);
        BigInteger y = BigInteger.valueOf(-1234);
        assertEquals(x.multiply(y), classUnderTest.multiply(x, y));
    }

    /**
     * Test method for
     * {@link KaratsubaMultiplicationImpl#multiply(BigInteger, BigInteger)}.
     */
    @Test
    public void testMultiply_complex_odd_even() {
        BigInteger x = BigInteger.valueOf(123);
        BigInteger y = BigInteger.valueOf(45);
        assertEquals(x.multiply(y), classUnderTest.multiply(x, y));
    }

    /**
     * Test method for
     * {@link KaratsubaMultiplicationImpl#multiply(BigInteger, BigInteger)}.
     */
    @Test
    public void testMultiply_complex_big_numbers() {
        BigInteger x = BigInteger.valueOf(123456789);
        BigInteger y = BigInteger.valueOf(95545444);
        assertEquals(x.multiply(y), classUnderTest.multiply(x, y));
    }
}
