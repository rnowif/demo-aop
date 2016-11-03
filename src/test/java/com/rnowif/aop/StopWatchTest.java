package com.rnowif.aop;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StopWatchTest {

    private class FakeClock extends Clock {
        private final long[] times;
        private int currentCall = 0;

        public FakeClock(long... times) {
            this.times = times;
        }

        @Override
        public ZoneId getZone() {
            return ZoneId.systemDefault();
        }

        @Override
        public Clock withZone(ZoneId zone) {
            return this;
        }

        @Override
        public Instant instant() {
            return Instant.ofEpochMilli(times[currentCall++]);
        }
    }

    @Test
    public void should_get_elapsed_time_in_millis() {
        final long DURATION_IN_MILLIS = 100L;
        StopWatch watch = new StopWatch(new FakeClock(0, DURATION_IN_MILLIS));
        watch.start();

        assertThat(watch.elapsed(), is(DURATION_IN_MILLIS));
    }
}