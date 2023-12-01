package com.always.demo.test3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler handler = new ProxyHandler(subject);
        Subject proxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        proxy.sayHello();
    }
}
