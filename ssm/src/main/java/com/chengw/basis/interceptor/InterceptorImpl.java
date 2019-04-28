package main.chapter2.interceptor;

import java.lang.reflect.Method;

public class InterceptorImpl implements Interceptor{
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法前逻辑");
        return false;
    }

    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后逻辑");

    }

    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代了被代理对象的方法");

    }
}
