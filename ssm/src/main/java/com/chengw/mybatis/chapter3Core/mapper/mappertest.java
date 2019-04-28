package main.mybatis.chapter3Core.mapper;

import main.mybatis.chapter3Core.pojo.Role;
import org.apache.ibatis.session.SqlSession;

import java.util.logging.Logger;

public class mappertest {

    private static SqlSession sqlSession = null;


    public static void main(String[] args) {

        try {
            Logger logger = Logger.getLogger(String.valueOf(mappertest.class));
            sqlSession = SqlSessionFactoryUtils.openSqlSession();

            //Role role = (Role) sqlSession.selectOne("main.mybatis.chapter3Core.mapper.RoleMapper.getRole",1);
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);//推荐用法
            Role role = roleMapper.getRole(1);
            System.out.println(role.toString());

            logger.info(role.getRoleName());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }



    }
}
