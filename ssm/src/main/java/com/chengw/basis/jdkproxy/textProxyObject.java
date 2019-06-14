package com.chengw.basis.jdkproxy;



public class textProxyObject {
    public textProxyObject() {
        JdkProxyExample jdk = new JdkProxyExample();
        main.chapter2.jdkproxy.HelloWord proxy = (main.chapter2.jdkproxy.HelloWord)jdk.bind(new HelloWordImpl());
        proxy.sayHelloWorld();
    }

    public static void main(String[] args) {
        new textProxyObject();
    }
}
