package main.springDemo.aop.framework.namespace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NameSpaceDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop-namespace.xml");

        NewDocumentarist newDocumentarist = (NewDocumentarist) context.getBean("documentarist");

        newDocumentarist.execute();
    }
}
