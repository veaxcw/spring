package main.springDemo.aop.pointcut.regexMatchMethodPointCut;

import main.springDemo.aop.pointcut.dynmicMethodMatcherPointCut.SampleBeanAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

public class RegexPointCutDemo {
    public static void main(String[] args) {
        Guitarist target = new Guitarist();

        JdkRegexpMethodPointcut j = new JdkRegexpMethodPointcut();
        /**所有以sing开头的方法都会应用advice*/
        j.setPatterns(".*sing.*");

        Advisor advisor = new DefaultPointcutAdvisor(j,new SampleBeanAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        Guitarist proxy = (Guitarist) proxyFactory.getProxy();

        proxy.sing();
        proxy.singWTF();
        proxy.talk();
    }
}
