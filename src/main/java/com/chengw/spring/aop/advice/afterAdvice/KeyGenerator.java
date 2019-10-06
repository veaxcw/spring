package com.chengw.spring.aop.advice.afterAdvice;

import java.util.Random;

public class KeyGenerator {
    protected static final long WEAK_KEY = 0XFFFFFFF0000000L;
    protected static final long STRONG_KEY = 0Xacdf03f590ae56L;

    Random r = new Random();


    public long getKey(){
        int x = r.nextInt(3);

        return x==1?WEAK_KEY:STRONG_KEY;
    }
}
