package main.springDemo.aop.framework.aspect;

import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRole(Role role) {

        System.out.println("name:" + role.getName() + "\n" + "note:" +  role.getNote());

    }
}
