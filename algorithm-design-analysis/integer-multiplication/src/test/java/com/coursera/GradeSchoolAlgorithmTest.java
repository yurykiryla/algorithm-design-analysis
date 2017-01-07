/**
 * 
 */

package com.coursera;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Test {@link GradeSchoolAlgorithm} class.
 * 
 * @author yuryk
 *
 */
public class GradeSchoolAlgorithmTest {

    private GradeSchoolAlgorithm gradeSchoolAlgorithm;

    /**
     * Init method.
     * 
     * @throws java.lang.Exception
     *             in case of any errors
     */
    @Before
    public void setUp() throws Exception {
        gradeSchoolAlgorithm = new GradeSchoolAlgorithm();
    }

    /**
     * Test method for
     * {@link GradeSchoolAlgorithm#multiply(BigInteger, BigInteger)}.
     */
    @Test
    public void testMultiply() {
        BigInteger first = BigInteger.valueOf(1234);
        BigInteger second = BigInteger.valueOf(5678);
        BigInteger expected = first.multiply(second);
        BigInteger actual = gradeSchoolAlgorithm.multiply(first, second);
        assertEquals(expected, actual);
    }

}
