package com.chengw.spring.aop.framework.proxyFactoryBean;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class AuditAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Executing: " + target.getClass().getName() +"."+ method.getName());
    }
}
