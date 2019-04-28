package main.springDemo.aop.framework.proxyFactoryBean;

import org.springframework.stereotype.Component;


public class Documentarist {
     private GrammyGuitarist guitarist;


    public void execute(){
         guitarist.sing();
         guitarist.talk();
     }

     public void setDep(GrammyGuitarist grammyGuitarist){
         this.guitarist = grammyGuitarist;
     }
}
