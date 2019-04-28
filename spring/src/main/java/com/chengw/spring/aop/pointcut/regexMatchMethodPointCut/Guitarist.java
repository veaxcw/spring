package main.springDemo.aop.pointcut.regexMatchMethodPointCut;

import main.common.Singer;

public class Guitarist implements Singer {
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
