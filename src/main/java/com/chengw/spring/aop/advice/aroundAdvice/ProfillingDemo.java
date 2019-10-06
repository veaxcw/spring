package com.chengw.spring.aop.advice.aroundAdvice;

import org.springframework.aop.framework.ProxyFactory;

public class ProfillingDemo {
    private static WorkBean getWorkBean(){
        WorkBean target = new WorkBean();
        ProfilingInterceptor interceptor = new ProfilingInterceptor();

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(interceptor);

        return (WorkBean) proxyFactory.getProxy();
    }

    public static void main(String[] args) {
        WorkBean workBean = getWorkBean();
        workBean.doSomeWord(100000000);
    }
}
