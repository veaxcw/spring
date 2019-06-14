package com.chengw.mybatis.chapter4Config;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

public class MyObjectFactory extends DefaultObjectFactory {

    Logger logger = Logger.getLogger(MyObjectFactory.class);

    private Object temp = null;

    @Override
    public <T> T create(Class<T> type) {
        T result = super.create(type);
        logger.info("创建对象：" + result.toString());
        logger.info("和temp是否相同: CC" + (temp == result));
        return result;
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T result = super.create(type, constructorArgTypes, constructorArgs);
        logger.info("创建对象：" + result.toString());
        temp = result;
        return result;

    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        logger.info("初始化参数："+ properties.toString());
    }

    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        return super.resolveInterface(type);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
