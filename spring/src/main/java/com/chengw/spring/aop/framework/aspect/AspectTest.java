package main.springDemo.aop.framework.aspect;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectTest {
    @Test
    public void Test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        RoleService roleService = context.getBean(RoleService.class);

        Role role = new Role();
        role.setName("veax");
        role.setNote("handsome");

        roleService.printRole(role);
    }
}
