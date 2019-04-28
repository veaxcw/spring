package main.springDemo.aop.pointcut.dynmicMethodMatcherPointCut;

public class SampleBean {
    public void foo(int x){
        System.out.println("Invoke foo:" + x);
    }

    public void bar(){
        System.out.println("Invoke bar!");
    }
}
