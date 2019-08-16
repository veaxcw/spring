package com.chengw.spring.aop.framework.aspect;

import com.chengw.spring.aop.framework.aspect.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRole(main.springDemo.aop.framework.aspect.Role role) {

        System.out.println("name:" + role.getName() + "\n" + "note:" +  role.getNote());

    }
}
