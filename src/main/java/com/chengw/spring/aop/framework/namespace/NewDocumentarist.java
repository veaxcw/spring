package com.chengw.spring.aop.framework.namespace;


import com.chengw.spring.aop.framework.proxyFactoryBean.Documentarist;
import com.chengw.spring.aop.framework.proxyFactoryBean.GrammyGuitarist;

public class NewDocumentarist extends Documentarist {

    private GrammyGuitarist guitarist;

    @Override
    public void execute(){
        guitarist.sing();
        guitarist.talk();
        guitarist.rest();
    }

    public void setDep(GrammyGuitarist grammyGuitarist){
        this.guitarist = grammyGuitarist;
    }
}
