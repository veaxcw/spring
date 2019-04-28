package main.springDemo.aop.advice.beforeAdvice;

import org.junit.jupiter.api.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before:" + method.getName() + " tune guitar");
    }

    @Test
    public void test(){
        Guitarist guitarist = new Guitarist();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(guitarist);

        Guitarist proxy = (Guitarist) proxyFactory.getProxy();

        proxy.sing();
    }
}
