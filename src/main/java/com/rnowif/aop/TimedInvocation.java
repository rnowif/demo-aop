package com.rnowif.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Clock;

public class TimedInvocation {

    private static final Logger LOG = LoggerFactory.getLogger(TimedInvocation.class);

    public <T> T invoke(InvocationPoint<T> invocationPoint) throws Exception {
        StopWatch watch = new StopWatch(Clock.systemDefaultZone());
        watch.start();
        LOG.info("Start calculation");
        T result = invocationPoint.invoke();
        LOG.info("End calculation ({} ms)", watch.elapsed());
        return result;
    }
}
