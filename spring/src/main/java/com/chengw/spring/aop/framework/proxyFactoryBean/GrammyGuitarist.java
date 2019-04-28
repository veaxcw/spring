package main.springDemo.aop.framework.proxyFactoryBean;

import main.common.Guitar;
import main.springDemo.aop.advice.beforeAdvice.Guitarist;
import main.common.Singer;

public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("waiting for offer");
    }

    public void sing(Guitar guitar){
        System.out.println("plar:" + guitar.play());
    }

    public void rest(){
        System.out.print("sleeping");
    }

    public void talk(){
        System.out.println("get out");
    }

}
