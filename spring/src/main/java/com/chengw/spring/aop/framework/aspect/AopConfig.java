package main.springDemo.aop.framework.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("main.springDemo.aop.framework.aspect")
public class AopConfig {
    @Bean
    public RoleAspect getRoleAspect(){
        return new RoleAspect();
    }
}
