package com.always.demo.test4;

public class Main {
    public static void main(String[] args) {
        HelloService proxy = (HelloService) new HelloServiceInterceptor().getProxy(HelloService.class);
        proxy.hello("张三");
        proxy.hi("cglib动态代理");
    }
}
