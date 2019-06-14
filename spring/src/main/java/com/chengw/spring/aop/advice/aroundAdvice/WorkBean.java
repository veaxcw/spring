package com.chengw.spring.aop.advice.aroundAdvice;

public class WorkBean {
    public void doSomeWord(int n){
        for(int i = 0;i < n;i++){
            work();
        }
    }
    private void work(){
        System.out.print("");
    }
}
