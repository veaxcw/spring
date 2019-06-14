package com.chengw.spring.aop.pointcut.regexMatchMethodPointCut;

import com.chengw.spring.hibernate.pojo.Singer;

/**
 * @author chengw
 */
public class Guitarist extends Singer {

    @Override
    public void sing() {
        System.out.println("what the fuck");
    }

    public void singWTF(){
        System.out.println("fuck everything");
    }

    public void talk(){
        System.out.println("fuck off");
    }
}
