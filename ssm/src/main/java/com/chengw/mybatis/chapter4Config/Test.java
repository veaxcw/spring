package main.mybatis.chapter4Config;

import main.mybatis.chapter3Core.mapper.RoleMapper;
import main.mybatis.chapter3Core.mapper.SqlSessionFactoryUtils;
import main.mybatis.chapter3Core.pojo.Role;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Test {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

        Role role = roleMapper.findRoleByRoleName("veax");

        System.out.println(role.toString());

        Role role1 = roleMapper.findRoleByNote("fresh");

        System.out.println(role1.toString());
    }
}
