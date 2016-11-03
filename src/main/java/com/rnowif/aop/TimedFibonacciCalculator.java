package com.rnowif.aop;

public class TimedFibonacciCalculator implements FibonacciCalculator {

    private final FibonacciCalculator calculator;

    public TimedFibonacciCalculator(FibonacciCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calculate(int n) {
        return new TimedInvocation().invoke(
                () -> calculator.calculate(n)
        );
    }
}
