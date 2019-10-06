package main.springDemo.aop.advice.beforeAdvice.application;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/***使用前置通知来保护方法的访问**/
public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        UserInfo userInfo = securityManager.getLoggedUser();

        if(userInfo == null){
            System.out.println("No Logger");
            throw new SecurityException("u must login before invoke " + method.getName());
        }else if("veax".equals(userInfo.getUserName())){
            System.out.println(" access accepted");
        }else {
            System.out.println("Illegal userName");
        }

    }
}
