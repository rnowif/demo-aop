package com.rnowif.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FibonacciCalculatorImplTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 },
                { 1, 1 },
                { 2, 1 },
                { 3, 2 },
                { 4, 3 },
                { 5, 5 },
                { 6, 8 }
        });
    }

    private final int input;
    private final int expected;

    public FibonacciCalculatorImplTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }
    
    @Test
    public void should_compute_fibonacci_number() {
        assertThat(new FibonacciCalculatorImpl().calculate(input), is(expected));
    }

}