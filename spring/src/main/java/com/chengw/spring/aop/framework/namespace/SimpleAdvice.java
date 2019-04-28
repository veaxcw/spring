package main.springDemo.aop.framework.namespace;

import org.aspectj.lang.JoinPoint;

import org.springframework.stereotype.Component;

@Component
public class SimpleAdvice {
    public void simpleAdviceBeforeAdvice(JoinPoint joinPoint){
        System.out.println("Executing " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}
