package main.springDemo.aop.pointcut.dynmicMethodMatcherPointCut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleDynamicPointCut extends DynamicMethodMatcherPointcut {

    /**检查多个条件,满足则应用Advice**/

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("Static check for" + method.getName());

        int x = ((Integer)args[0]).intValue();

        return (x != 100);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("Static check for" + method.getName());
        return ("foo".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter() {
        return (cls->(cls == SampleBean.class));
    }
}
