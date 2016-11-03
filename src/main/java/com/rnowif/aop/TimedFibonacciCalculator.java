package com.rnowif.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;

public class TimedFibonacciCalculator implements FibonacciCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciCalculatorImpl.class);

    private final FibonacciCalculator calculator;

    public TimedFibonacciCalculator(FibonacciCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calculate(int n) {
        StopWatch watch = new StopWatch(Clock.systemDefaultZone());
        watch.start();
        LOG.info("Start calculation for number {}", n);
        int result = calculator.calculate(n);
        LOG.info("End calculation for number {} ({} ms)", n, watch.elapsed());
        return result;
    }
}
