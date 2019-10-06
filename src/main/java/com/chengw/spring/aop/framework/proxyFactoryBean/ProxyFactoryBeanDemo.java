package com.chengw.spring.aop.framework.proxyFactoryBean;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProxyFactoryBeanDemo {

    //todo
    public static void main(String[] args) {



        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        Documentarist documentaristOne = (Documentarist) context.getBean("documentaristOne");
        Documentarist documentaristTwo = (Documentarist) context.getBean("documentaristTwo");

        System.out.println("Documentarist One >>");
        documentaristOne.execute();

        System.out.println("Documentarist Two >>");
        documentaristTwo.execute();
    }
}
