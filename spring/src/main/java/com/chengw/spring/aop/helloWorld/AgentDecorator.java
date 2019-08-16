package com.chengw.spring.aop.helloWorld;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**拦截器**/
public class AgentDecorator implements MethodInterceptor {
    
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        
        System.out.println("James");
        
        Object retVal = invocation.proceed();
        
        System.out.println("!");
        
        return retVal;
    }
}
