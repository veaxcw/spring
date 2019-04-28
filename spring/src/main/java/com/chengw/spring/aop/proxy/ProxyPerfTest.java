package main.springDemo.aop.proxy;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {
    public static void main(String[] args) {
        DefaultSimpleBean target = new DefaultSimpleBean();

        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(),new NoOpBeforeAdvice());

        runJdkTest(advisor,target);
        System.out.println("************");
        runCGLIBTest(advisor,target);
        System.out.println("************");
        runCGLIBFrozenTest(advisor,target);

    }

    private static void runCGLIBFrozenTest(Advisor advisor,SimpleBean target){
        ProxyFactory proxyFactory = new ProxyFactory();
        /** Set whether to proxy the target class directly, instead of just proxying
         * specific interfaces. Default is "false"**/
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);
        proxyFactory.setFrozen(true);

        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();

        System.out.println("running CGLIBFrozen test");
        test(proxy);
    }


    /**测试CGLIB代理**/
    private static void runCGLIBTest(Advisor advisor,SimpleBean target){
        ProxyFactory proxyFactory = new ProxyFactory();
        /** Set whether to proxy the target class directly, instead of just proxying
         * specific interfaces. Default is "false"**/
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();

        System.out.println("running CGLIB test");
        test(proxy);
    }
    /**测试jdk代理**/
    private static void runJdkTest(Advisor advisor,SimpleBean target){
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        SimpleBean proxy = (SimpleBean) proxyFactory.getProxy();

        System.out.println("running jdk test");
        test(proxy);
    }
    /**测试方法**/
    private static void test(SimpleBean bean){
        long before = 0;
        long after = 0;

        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for (int i = 0;i < 500000;i++){
            bean.advised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took:" + (after - before) + "ms");

        System.out.println("Testing unAdvised Method");
        before = System.currentTimeMillis();
        for (int i = 0;i < 50000;i++){
            bean.unAdvised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took:" + (after - before) + "ms");


        System.out.println("Testing equal Method");
        before = System.currentTimeMillis();
        for (int i = 0;i < 50000;i++){
            bean.equals(bean);
        }
        after = System.currentTimeMillis();
        System.out.println("Took:" + (after - before) + "ms");

        System.out.println("Testing hashcode Method");
        before = System.currentTimeMillis();
        for (int i = 0;i < 50000;i++){
            bean.hashCode();
        }
        after = System.currentTimeMillis();
        System.out.println("Took:" + (after - before) + "ms");

        System.out.println("Testing Advised.getProxyTargetClass Method");
        Advised  advised = (Advised)bean;
        before = System.currentTimeMillis();
        for (int i = 0;i < 50000;i++){
            advised.getTargetClass();
        }
        after = System.currentTimeMillis();
        System.out.println("Took:" + (after - before) + "ms");
    }

}




