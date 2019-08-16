package com.chengw.spring.aop.helloWorld;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author chengw
 */
public class AgentAOPDemo {

    public static void main(String[] args) {
        Agent agent = new Agent();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(agent);

        Agent proxy = (Agent) proxyFactory.getProxy();

        agent.speak();
        System.out.println("");
        proxy.speak();
    }
}
