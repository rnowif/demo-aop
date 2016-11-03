package com.rnowif.aop;

import com.rnowif.aop.proxy.Proxifier;
import com.rnowif.aop.proxy.TimedInvocationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FibonacciApplication {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciApplication.class);

    public static void main(String[] args) {
        FibonacciCalculator calculator = new Proxifier().proxify(
                FibonacciCalculator.class,
                new TimedInvocationHandler(new FibonacciCalculatorImpl())
        );

        LOG.info("25th fibonacci number : {}", calculator.calculate(25));
    }


}
