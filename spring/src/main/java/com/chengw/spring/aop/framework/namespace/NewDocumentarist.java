package main.springDemo.aop.framework.namespace;

import main.springDemo.aop.framework.proxyFactoryBean.Documentarist;
import main.springDemo.aop.framework.proxyFactoryBean.GrammyGuitarist;

public class NewDocumentarist extends Documentarist {

    private GrammyGuitarist guitarist;


    public void execute(){
        guitarist.sing();
        guitarist.talk();
        guitarist.rest();
    }

    public void setDep(GrammyGuitarist grammyGuitarist){
        this.guitarist = grammyGuitarist;
    }
}
