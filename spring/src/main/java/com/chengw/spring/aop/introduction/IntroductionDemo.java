//package com.chengw.spring.aop.introduction;
//
//import org.springframework.aop.IntroductionAdvisor;
//import org.springframework.aop.framework.ProxyFactory;
//
//
////todo
///**有问题**/
//public class IntroductionDemo {
//    public static void main(String[] args) {
//        Contact target = new Contact();
////        target.setName("veax");
//
//        IntroductionAdvisor  advisor = new main.springDemo.aop.introduction.IsModifiedAdvisor();
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.addAdvisor(advisor);
//        proxyFactory.setTarget(target);
//        proxyFactory.setOptimize(true);//强制使用CGLIB代理
//
//        Contact proxy = (Contact) proxyFactory.getProxy();
//
//        main.springDemo.aop.introduction.IsModified proxyInterface = (main.springDemo.aop.introduction.IsModified) proxy;
//
//        System.out.println("Is Contact:" + (proxy instanceof Contact));
//        System.out.println("Is IsModified:" + (proxy instanceof main.springDemo.aop.introduction.IsModified));
//
//        System.out.println("Has been modified:" + proxyInterface.isModified());
//
////        proxy.setName("veax1");
//
//        System.out.println("Has been modified:" + proxyInterface.isModified());
////        proxy.setName("water");
////        System.out.println("Has been modified:" + proxyInterface.isModified());
//    }
//}
