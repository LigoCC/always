package com.always.demo.test3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private Subject subject;

    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method invocation");
        Object result = method.invoke(subject, args);
        System.out.println("After method invocation");
        return result;
    }
}
