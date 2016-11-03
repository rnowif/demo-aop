package com.rnowif.aop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;

public class FibonacciCalculatorImpl implements FibonacciCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciCalculatorImpl.class);

    @Override
    public int calculate(int n) {
        StopWatch watch = new StopWatch(Clock.systemDefaultZone());
        watch.start();
        LOG.info("Start calculation for number {}", n);
        int result = n;
        if (n > 1) {
            result = calculate(n-1) + calculate(n-2);
        }
        LOG.info("End calculation for number {} ({} ms)", n, watch.elapsed());
        return result;
    }
}
