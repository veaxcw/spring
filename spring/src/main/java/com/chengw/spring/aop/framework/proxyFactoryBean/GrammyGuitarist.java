package com.chengw.spring.aop.framework.proxyFactoryBean;


import com.chengw.spring.hibernate.pojo.Singer;

/**
 * @author chengw
 */
public class GrammyGuitarist extends Singer {

    @Override
    public void sing() {
        System.out.println("waiting for offer");
    }

//    public void sing(Guitar guitar){
//        System.out.println("plar:" + guitar.play());
//    }

    public void rest(){
        System.out.print("sleeping");
    }

    public void talk(){
        System.out.println("get out");
    }

}
