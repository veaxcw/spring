package com.chengw.spring.aop.advice.afterAdvice;


import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import static com.chengw.spring.aop.advice.afterAdvice.KeyGenerator.WEAK_KEY;


/**
 * @author chengw
 */
public class WeakKeyCheckAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        if(o1 instanceof KeyGenerator && ("getKey".equals(method.getName()))){
            //获取返回值
            long key = ((Long) o).longValue();

            if(key == WEAK_KEY) {
                throw new SecurityException("weak key! try again");
            }
        }

    }
}
