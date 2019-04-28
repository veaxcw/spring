package main.springDemo.aop.pointcut.staticMethodMatcherPointCut;

import main.common.Singer;

public class GreatGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("I am the God");
    }
}
