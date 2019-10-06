package main.springDemo.aop.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {

    private boolean isModified = false;

    /**方法缓存**/
    private Map<Method,Method> methodCache = new HashMap<>();

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Override
    /*该方法在isModified之前执行***/
    public Object invoke(MethodInvocation mi) throws Throwable {
        if(!isModified){
            if(mi.getMethod().getName().startsWith("set") && mi.getArguments().length == 1){
                Method getter = getGetter(mi.getMethod());
                if(getter != null) {
                    /**获取当前方法的参数**/
                    Object newVal = mi.getArguments()[0];
                    /**执行getter方法**/
                    Object oldVal = getter.invoke(mi.getThis(),null);///????todo
                    if(newVal == null && oldVal == null)
                        isModified = false;
                    else if(newVal == null && oldVal != null)
                        isModified = true;
                    else if(newVal != null && oldVal == null)
                        isModified = true;
                    else
                        isModified = !newVal.equals(oldVal);
                }
            }
        }

        return super.invoke(mi);
    }

    /**通过setter检索相应的getter**/
    private Method getGetter(Method setter){
        Method getter = methodCache.get(setter);
        if(getter != null)
            return getter;

        String getterName = setter.getName().replaceFirst("set","get");

        try {
            getter = setter.getDeclaringClass().getMethod(getterName,null);
            synchronized (methodCache){
                methodCache.put(setter,getter);
            }
            return getter;
        } catch (NoSuchMethodException e) {
        }
        return null;
    }
}
