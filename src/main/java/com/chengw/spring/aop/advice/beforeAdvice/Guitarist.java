package com.chengw.spring.aop.advice.beforeAdvice;


import com.chengw.spring.hibernate.pojo.Singer;

public class Guitarist extends Singer {

    private String lyric = "You are gonna live forever in me";

    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
