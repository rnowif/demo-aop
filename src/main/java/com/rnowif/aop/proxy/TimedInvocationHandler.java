package com.rnowif.aop.proxy;

import com.rnowif.aop.Timed;
import com.rnowif.aop.TimedInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimedInvocationHandler implements InvocationHandler {

    private static final Class<Timed> ANNOTATION_CLASS = Timed.class;

    private final Object target;

    public TimedInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (isTimed(method)) {
            return new TimedInvocation().invoke(
                    () -> method.invoke(target, args)
            );
        }

        return method.invoke(target, args);
    }

    private boolean isTimed(Method method) throws NoSuchMethodException {
        // Is timed if the interface method or the target method is annotated
        return method.getDeclaredAnnotation(ANNOTATION_CLASS) != null
                || target.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes()).getDeclaredAnnotation(ANNOTATION_CLASS) != null;
    }
}
