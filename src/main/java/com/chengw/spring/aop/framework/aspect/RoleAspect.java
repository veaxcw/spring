//package com.chengw.spring.aop.framework.aspect
//
//
//import org.junit.After;
//import org.junit.Before;
//
//@Aspect
//public class RoleAspect {
//
//    /*定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码.
//    使用 @Pointcut 来声明切入点表达式.
//    后面的其他通知直接使用方法名来引用当前的切入点表达式. */
//    @Pointcut("execution(* main.springDemo.aop.framework.aspect.RoleServiceImpl.printRole*(..))")
//    public void print(){}
//
//    @Before("print()")
//    public void before(){
//        System.out.println("before....");
//    }
//
//    @After("print()")
//    public void after(){
//        System.out.println("after ...");
//    }
//
//    @AfterReturning("print()")
//    public void afterReturning(){
//        System.out.println("afterReturning......");
//    }
//
//    @AfterThrowing("print()")
//    public void afterThrowing(){
//        System.out.println("afterThrowing......");
//    }
//
//    @Around("print()")
//    public void around(ProceedingJoinPoint joinPoint){
//        System.out.println("around before");
//        try {
//            /**通过反射执行该方法**/
//            joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        System.out.println("around before");
//
//    }
//}
