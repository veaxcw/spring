package main.chapter2.jdkproxy;

public class textProxyObjest {
    public textProxyObjest() {
        JdkProxyExample jdk = new JdkProxyExample();
        HelloWord proxy = (HelloWord)jdk.bind(new HelloWordImpl());
        proxy.sayHelloWorld();
    }

    public static void main(String[] args) {
        new textProxyObjest();
    }
}
