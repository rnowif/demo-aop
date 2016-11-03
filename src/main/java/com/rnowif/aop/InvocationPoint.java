package com.rnowif.aop;

@FunctionalInterface
public interface InvocationPoint<T> {

    T invoke() throws Exception;
}
