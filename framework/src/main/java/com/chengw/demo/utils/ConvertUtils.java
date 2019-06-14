package com.chengw.demo.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 实现Bean与Entity的相互转换
 * 我留着自己用
 *
 * **/
public class ConvertUtils<T1, T2> {


    /**T2 转换成 T1***/
    public T1 entityToBean(T1 t1, T2 t2,String fields){


        Class<T2> t2Class = (Class<T2>)t2.getClass();

        Class<T1> t1Class = (Class<T1>)t1.getClass();

        /**获取该类及其父类所有public 方法*/
        Method[] t2ClassMethods = t2Class.getMethods();
        Method[] t1ClassMethods = t1Class.getMethods();

        /**类似bean.set***(entity.get***())**/
        for(Method t2Method:t2ClassMethods){
            String t2MethodName = t2Method.getName();
            //截取get或者set方法名中的field名
            String fieldName = t2MethodName.substring(3).toLowerCase();
            //转换指定一个或者多个fields
            //fields == null 则默认为全部转化
            if (fields.contains(fieldName)||fields == null) {
                for(Method t1Method:t1ClassMethods){
                    String t1MethodName = t1Method.getName().toLowerCase();

                    if(t1MethodName.contains(fieldName) && t1MethodName.contains("set") && t2MethodName.contains("get")){
                        //调用t1.setField(t2.getField())
                        try {
                            t1Method.invoke(t1,t2Method.invoke(t2,null));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }

        }
        return  t1;
    }

}
