/**
 * https://www.coursera.org/learn/algorithm-design-analysis/lecture/
 * wKEYL/karatsuba-multiplication
 */

package com.coursera;

import java.math.BigInteger;

/**
 * Multiplication interface.
 * @author yuryk
 *
 */
public interface KaratsubaMultiplication {

    /**
     * Multiply two numbers.
     * @param x first number
     * @param y second number
     * @return result
     */
    BigInteger multiply(BigInteger x, BigInteger y);

}
