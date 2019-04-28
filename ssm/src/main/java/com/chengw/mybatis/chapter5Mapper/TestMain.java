package main.mybatis.chapter5Mapper;


import main.mybatis.chapter3Core.mapper.SqlSessionFactoryUtils;
import main.mybatis.chapter5Mapper.DAO.EmployeeDAO;
import main.mybatis.chapter5Mapper.pojo.Employee;

import org.apache.ibatis.session.SqlSession;



import org.apache.log4j.Logger;

public class TestMain {



    public static void main(String[] args) {

        Logger  logger = Logger.getLogger(TestMain.class);

        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSessionFactoryUtils.openSqlSession();

            EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);

            Employee employee  = employeeDAO.getEmployee(1);




            logger.info(String.valueOf(employee.getBirthday()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null)
                sqlSession.close();

        }


    }
}
