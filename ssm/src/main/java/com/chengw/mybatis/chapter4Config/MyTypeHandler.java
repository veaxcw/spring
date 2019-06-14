package com.chengw.mybatis.chapter4Config;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class MyTypeHandler implements TypeHandler<String> {

    Logger logger = Logger.getLogger(String.valueOf(MyTypeHandler.class));

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

        logger.info("设置string参数：" + s);
        preparedStatement.setString(i,s);
    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        String result = resultSet.getString(s);
        logger.info("读取参数：" +  result);
        return result;
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        String result = resultSet.getString(i);
        logger.info("读取参数：" +  result);
        return result;
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        String result = callableStatement.getString(i);
        logger.info("读取参数：" +  result);
        return result;
    }
}
