package com.rnowif.aop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TimedInvocationTest {
    
    @Test
    public void should_return_invocation_result() throws Exception {
        assertThat(new TimedInvocation().invoke(() -> 2), is(2));
    }

}