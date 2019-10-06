package com.chengw.spring.aop.pointcut.staticMethodMatcherPointCut;

import com.chengw.spring.hibernate.pojo.Singer;

public class GreatGuitarist extends Singer {
    public void sing() {
        System.out.println("I am the God");
    }
}
