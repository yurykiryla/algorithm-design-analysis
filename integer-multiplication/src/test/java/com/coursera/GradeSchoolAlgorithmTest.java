/**
 * 
 */
package com.coursera;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

/**
 * @author yuryk
 *
 */
public class GradeSchoolAlgorithmTest {

  private GradeSchoolAlgorithm gradeSchoolAlgorithm;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    gradeSchoolAlgorithm = new GradeSchoolAlgorithm();
  }

  /**
   * Test method for
   * {@link com.coursera.GradeSchoolAlgorithm#multiply(java.math.BigInteger, java.math.BigInteger)}.
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
