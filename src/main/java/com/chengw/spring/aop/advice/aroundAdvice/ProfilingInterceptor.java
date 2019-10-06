package com.chengw.spring.aop.advice.aroundAdvice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        StopWatch sw = new StopWatch();
        sw.start(methodInvocation.getMethod().getName());
        Object returnValue = methodInvocation.proceed();
        sw.stop();
        dumpInfo(methodInvocation,sw.getTotalTimeSeconds());
        return null;
    }

    private void dumpInfo(MethodInvocation invocation,double ms){
        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        Object args = invocation.getArguments();

        System.out.println("Executed method:" + method.getName());
        System.out.println("ObjectType:" + target.getClass().getName());

        System.out.print("Arguments:");
        for(int i = 0;i < ((Object[]) args).length;i++){
            System.out.print(">" + args);
        }
        System.out.print("\n");
        System.out.println("Took:" + ms);


     }
}
