package com.chengw.spring.aop.pointcut.nameMathMethodPointCut;

import com.chengw.spring.hibernate.pojo.Singer;


/**
 * @author chengw
 */
public class GrammyGuitarist extends Singer {

    @Override
    public void sing() {
            System.out.println();
    }
}
//名字匹配没什么意思
//todo
