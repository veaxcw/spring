package com.chengw.spring.aop.proxy;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class TestPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return ("advice".equals(method.getName()));
    }
}
