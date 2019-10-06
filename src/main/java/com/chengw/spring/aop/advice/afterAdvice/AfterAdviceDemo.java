package com.chengw.spring.aop.advice.afterAdvice;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceDemo {
    public static void main(String[] args) {

        KeyGenerator keyGenerator = getKeyGenerator();

        for(int i = 0; i < 10; i++){
            try {
                long key = keyGenerator.getKey();
                System.out.println("key:0x" + Long.toHexString(key));
            } catch (SecurityException e) {
                System.out.println("Weak Key Generated");
            }
        }


    }

    private static KeyGenerator getKeyGenerator(){
        KeyGenerator target = new KeyGenerator();
        WeakKeyCheckAdvice advice = new WeakKeyCheckAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);

        return (KeyGenerator) proxyFactory.getProxy();
    }

}
