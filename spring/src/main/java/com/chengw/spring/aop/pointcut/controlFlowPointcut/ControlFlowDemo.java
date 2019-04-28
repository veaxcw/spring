package main.springDemo.aop.pointcut.controlFlowPointcut;


import main.connectionPool.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowDemo {
    public static void main(String[] args) {
        ControlFlowDemo ex = new ControlFlowDemo();
        ex.run();
    }

    private void run(){
        TestBean target = new TestBean();
        Pointcut pointcut =  new ControlFlowPointcut(ControlFlowDemo.class,"test");
        Advisor advisor = new DefaultPointcutAdvisor( pointcut,new SampleBeanAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        TestBean proxy = (TestBean) proxyFactory.getProxy();
        System.out.println("Normal invoke");
        proxy.foo();
        System.out.println("ControlFlow invoke");
        test(proxy);
    }

    private void test(TestBean testBean){
        testBean.foo();
    }

}
