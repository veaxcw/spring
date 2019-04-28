package main.springDemo.aop.pointcut.controlFlowPointcut;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SampleBeanAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before invoke " + method.getName());
    }
}
