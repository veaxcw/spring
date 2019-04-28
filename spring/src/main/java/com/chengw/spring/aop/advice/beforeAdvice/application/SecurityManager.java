package main.springDemo.aop.advice.beforeAdvice.application;

public class SecurityManager {

    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();//ThreadLocal 代表线程的局部变量

    public void login(String userName,String password){
        threadLocal.set(new UserInfo(userName,password));
    }

    public void logout(){
        threadLocal.set(null);
    }

    public UserInfo getLoggedUser(){
        return threadLocal.get();
    }
}
