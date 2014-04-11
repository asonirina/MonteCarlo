package com.by.iason.generator;

/**
 * User: iason
 * Date: 11.04.14
 */
public class LFSRGenerator {
    private static double MAX = Math.pow(2, 32);
    private long s = 1;

    private static long primitivePolynomial(long s) {
        return ((((s >> 31) ^ (s >> 30) ^ (s >> 29) ^ (s >> 27) ^ (s >> 25) ^ s) & 1) << 31) | (s >> 1);
    }

    public double getNext() {
        long res = 0;
        int i = 0;
        while (i < 32) {
            long s1 = s & 1;
            s = primitivePolynomial(s);
            long s2 = s & 1;
            if (s1 == 1) {
                res = (res << 1) + s2;
                i++;
            }
        }

        return res / MAX;
    }

}
