package main.springDemo.aop.pointcut.aspectMetchMethodPointcut;

import main.springDemo.aop.pointcut.dynmicMethodMatcherPointCut.SampleBeanAdvice;
import main.springDemo.aop.pointcut.regexMatchMethodPointCut.Guitarist;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

@SuppressWarnings("ALL")
public class AspectMetchMethodPointcutDemo {

    public static void main(String[] args) {
        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* sing*(..))");

        Advisor advisor = new DefaultPointcutAdvisor(pc,new SampleBeanAdvice());

        Guitarist target = new Guitarist();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        Guitarist proxy = (Guitarist) proxyFactory.getProxy();

        proxy.sing();
        proxy.singWTF();
        proxy.talk();
    }
}
