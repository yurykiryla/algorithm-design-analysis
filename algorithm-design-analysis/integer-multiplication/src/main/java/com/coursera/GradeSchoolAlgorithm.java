/**
 * 
 */

package com.coursera;

import java.math.BigInteger;

/**
 * {@link GradeSchoolAlgorithm} implementation.
 * 
 * @author yuryk
 *
 */
public class GradeSchoolAlgorithm {

    /**
     * Multiply numbers.
     * 
     * @param first
     *            first number
     * @param second
     *            second number
     * @return {@link BigInteger} value
     */
    public BigInteger multiply(BigInteger first, BigInteger second) {
        int[] firstDigits = getDigits(first);
        int[] secondDigits = getDigits(second);
        int sum = 0;

        for (int i = 0; i < firstDigits.length; i++) {
            int other = 0;
            int jcount;
            for (jcount = 0; jcount < secondDigits.length; jcount++) {
                int temp = secondDigits[jcount] * firstDigits[i];
                temp += other;
                if (temp >= 10) {
                    int[] tempArr = getDigits(BigInteger.valueOf(temp));
                    other = tempArr[1];
                    temp = tempArr[0];
                } else {
                    other = 0;
                }
                sum += temp * Math.pow(10, jcount + i);
            }
            sum += other * Math.pow(10, jcount + i);
        }
        return BigInteger.valueOf(sum);

    }

    private int[] getDigits(BigInteger number) {
        String line = number.toString();
        int[] result = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(line.charAt(line.length() - 1 - i)));
        }
        return result;
    }

}
