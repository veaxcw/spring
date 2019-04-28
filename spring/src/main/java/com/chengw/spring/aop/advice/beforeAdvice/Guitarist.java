package main.springDemo.aop.advice.beforeAdvice;

import main.common.Singer;

public class Guitarist implements Singer {

    private String lyric = "You are gonna live forever in me";

    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
