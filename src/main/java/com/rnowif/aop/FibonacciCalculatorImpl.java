package com.rnowif.aop;


public class FibonacciCalculatorImpl implements FibonacciCalculator {

    @Override
    public int calculate(int n) {
        int result = n;
        if (n > 1) {
            result = calculate(n-1) + calculate(n-2);
        }
        return result;
    }
}
