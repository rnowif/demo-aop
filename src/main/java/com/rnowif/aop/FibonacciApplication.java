package com.rnowif.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciApplication {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciApplication.class);

    public static void main(String[] args) {
        FibonacciCalculator calculator = new TimedFibonacciCalculator(new FibonacciCalculatorImpl());
        LOG.info("10th fibonacci number : {}", calculator.calculate(25));
    }
}
