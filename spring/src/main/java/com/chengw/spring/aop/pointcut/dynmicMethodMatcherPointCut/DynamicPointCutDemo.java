package main.springDemo.aop.pointcut.dynmicMethodMatcherPointCut;

import main.springDemo.aop.pointcut.staticMethodMatcherPointCut.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointCutDemo {

    public static void main(String[] args) {
        SampleBean target = new SampleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointCut(),new SampleBeanAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        SampleBean proxy = (SampleBean) proxyFactory.getProxy();

        proxy.foo(1);
        proxy.foo(50);
        proxy.foo(100);

        proxy.bar();
    }
}
