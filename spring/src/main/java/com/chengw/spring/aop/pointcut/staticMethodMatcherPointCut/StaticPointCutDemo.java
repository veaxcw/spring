package com.chengw.spring.aop.pointcut.staticMethodMatcherPointCut;

import com.chengw.spring.hibernate.pojo.Singer;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointCutDemo {

    public static void main(String[] args) {
        GoodGuitarist veax = new GoodGuitarist();
        GreatGuitarist water  = new GreatGuitarist();

        Singer proxy_1;
        Singer proxy_2;

        Pointcut pointcut = new SimpleStaticPointCut();

        Advice advice = new SimpleAdvice();

        //只将通知应用于GoodGuitarist类
        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(veax);
        proxyFactory.addAdvisor(advisor);
        proxy_1 = (Singer) proxyFactory.getProxy();

        proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(water);
        proxyFactory.addAdvisor(advisor);
        proxy_2 = (Singer) proxyFactory.getProxy();

        proxy_1.sing();
        proxy_2.sing();

    }


}
