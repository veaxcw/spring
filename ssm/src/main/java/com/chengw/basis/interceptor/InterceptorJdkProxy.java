package main.chapter2.interceptor;



import main.chapter2.jdkproxy.HelloWord;
import main.chapter2.jdkproxy.HelloWordImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

    private Object target = null;//真实对象
    private String interceptorClass = null;

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    public static Object bind(Object target, String interceptorClass) {//返回代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClass));
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (interceptorClass == null) {//如果拦截器为空则反射真实对象的方法
            return method.invoke(target, args);
        }
        Object result = null;

        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();

        if (interceptor.before(proxy, target, method, args)) {
            result = method.invoke(target, args);
        } else {
            interceptor.around(proxy, target, method, args);
        }
        interceptor.after(proxy, target, method, args);//用拦截器方法取代了真实对象的方法
        return null;
    }

    public static void main(String[] args) {
        HelloWord proxy = (HelloWord)InterceptorJdkProxy.bind(new HelloWordImpl(),"main.springDemo.basis.interceptor.InterceptorImpl");
        proxy.sayHelloWorld();
    }

}


