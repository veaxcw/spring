package main.springDemo.aop.advice.afterAdvice;


import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import static main.springDemo.aop.advice.afterAdvice.KeyGenerator.WEAK_KEY;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        if(o1 instanceof KeyGenerator && ("getKey".equals(method.getName()))){
            long key = ((Long) o).longValue();//获取返回值

            if(key == WEAK_KEY)
                throw new SecurityException("weak key! try again");
        }

    }
}
