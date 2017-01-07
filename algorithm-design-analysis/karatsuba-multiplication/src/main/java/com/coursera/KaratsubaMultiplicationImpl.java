/**
 * https://www.coursera.org/learn/algorithm-design-analysis/lecture/
 * wKEYL/karatsuba-multiplication
 */

package com.coursera;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * {@link KaratsubaMultiplication} implementation.
 * 
 * @author yuryk
 *
 */
public class KaratsubaMultiplicationImpl implements KaratsubaMultiplication {

    /**
     * {@inheritDoc}.
     */
    @Override
    public BigInteger multiply(final BigInteger x, final BigInteger y) {
        int signum = x.signum() * y.signum();
        if (signum == 0) {
            return BigInteger.ZERO;
        }

        BigInteger absX = x.abs();
        BigInteger absY = y.abs();

        if (absX.compareTo(BigInteger.TEN) < 0 && absY.compareTo(BigInteger.TEN) < 0) {
            return x.multiply(y);
        }

        int[] arrayX = getIntArray(absX);
        int[] arrayY = getIntArray(absY);

        int multiplier = 1;

        if (arrayX.length % 2 == 1) {
            arrayX = increaseArrayWithZero(arrayX, 1);
            multiplier *= 10;
        }

        if (arrayY.length % 2 == 1) {
            arrayY = increaseArrayWithZero(arrayY, 1);
            multiplier *= 10;
        }

        if (arrayX.length != arrayY.length) {
            int delta = arrayX.length - arrayY.length;
            if (delta > 0) {
                arrayY = increaseArrayWithZero(arrayY, delta);
            } else {
                delta *= -1;
                arrayX = increaseArrayWithZero(arrayX, delta);
            }
            multiplier *= Math.pow(10, delta);
        }

        BigInteger a = getBigIntFromArray(Arrays.copyOfRange(arrayX, 0, arrayX.length / 2));
        BigInteger b = getBigIntFromArray(
                Arrays.copyOfRange(arrayX, arrayX.length / 2, arrayX.length));
        BigInteger c = getBigIntFromArray(Arrays.copyOfRange(arrayY, 0, arrayY.length / 2));
        BigInteger d = getBigIntFromArray(
                Arrays.copyOfRange(arrayY, arrayY.length / 2, arrayY.length));

        BigInteger step1 = multiply(a, c);
        BigInteger step2 = multiply(b, d);
        BigInteger step3 = multiply(a.add(b), c.add(d));
        BigInteger step4 = step3.subtract(step2).subtract(step1);

        BigInteger result = step1.multiply(BigInteger.valueOf((long) Math.pow(10, arrayX.length)));
        result = result
                .add(step4.multiply(BigInteger.valueOf((long) Math.pow(10, arrayX.length / 2.0))));
        result = result.add(step2);
        result = result.divide(BigInteger.valueOf(multiplier));
        result = result.multiply(BigInteger.valueOf(signum));

        return result;
    }

    private int[] getIntArray(BigInteger value) {
        String line = value.toString();
        int[] result = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(line.charAt(i)));
        }
        return result;
    }

    private int[] increaseArrayWithZero(int[] baseArray, int delta) {
        int[] result = Arrays.copyOf(baseArray, baseArray.length + delta);
        result[result.length - 1] = 0;
        return result;
    }

    private BigInteger getBigIntFromArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int l : array) {
            sb.append(l);
        }
        return new BigInteger(sb.toString());
    }
}
