package com.chengw.spring.aop.framework.proxyFactoryBean;

import com.chengw.spring.aop.pointcut.nameMathMethodPointCut.GrammyGuitarist;


/**
 * @author chengw
 */
public class Documentarist {

     private GrammyGuitarist guitarist;


    public void execute(){
         guitarist.sing();
//         guitarist.talk();
     }

     public void setDep(GrammyGuitarist grammyGuitarist){
         this.guitarist = grammyGuitarist;
     }
}
