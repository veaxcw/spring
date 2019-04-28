package main.mybatis.chapter3Core.mapper;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionFactoryUtils(){}

    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized (LOCK){
            if(sqlSessionFactory != null)
                return sqlSessionFactory;
            else{
                String resource = "main/resources/mybatis-config.xml";
                try {
                    InputStream inputStream = Resources.getResourceAsStream(resource);
                    sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return  sqlSessionFactory;
    }

    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null){
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
