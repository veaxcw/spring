package main.springDemo.aop.advice.beforeAdvice.application;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        SecureBean bean = getSecureBean();

        securityManager.login("veax","123456" );
        bean.writeSecurityMessage();
        securityManager.logout();

        try {
            securityManager.login("invalid user","321");
            bean.writeSecurityMessage();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            securityManager.logout();
        }
    }

    private static SecureBean getSecureBean(){
        SecureBean secureBean = new SecureBean();

        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory proxy = new ProxyFactory();

        proxy.setTarget(secureBean);
        proxy.addAdvice(advice);

        return (SecureBean) proxy.getProxy();
    }
}
