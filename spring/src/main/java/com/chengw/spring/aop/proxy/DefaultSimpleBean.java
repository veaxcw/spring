package com.chengw.spring.aop.proxy;

public class DefaultSimpleBean implements SimpleBean {

    private long dummy = 0;

    @Override
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    @Override
    public void unAdvised() {
        dummy = System.currentTimeMillis();
    }
}
