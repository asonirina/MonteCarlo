package com.by.iason.integral;

import com.by.iason.generator.LFSRGenerator;

/**
 * User: iason
 * Date: 11.04.14
 */
public class Integral {

    private int N = 1000000;
    private LFSRGenerator generator = new LFSRGenerator();

    private double f1(double x) { //from 1 to inf
        return Math.exp(-x) * Math.pow(Math.sin(x), 5);
    }

    private double f2(double x, double y) {
        return (Math.pow(x, 3) + 3 * x * y) / Math.exp(-y);
    }

    public double doF1() {
        double res = 0;
        for (int i = 0; i < N; i++) {
            res += f1(generateValue());
        }

        return res / N;
    }

    public double doF2() {
        double res = 0;
        for ( int i = 0; i<N; i++) {
            double args[] = generateVector();
            res+=f2(args[0], args[1]);
        }

        return res*2/N;
    }

    private double generateValue() {
        return generator.getNext() + 1;
    }

    private double[] generateVector() {
        double res[] = new double[2];
        res[0] = generator.getNext() - 0.5;
        res[1] = generator.getNext() - 0.5;

        return res;
    }
}
