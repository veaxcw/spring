package com.cbim.spring.test;

import com.cbim.demo.po.AreaBean;
import com.cbim.spring.beanFactory.BeanFactory;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanFactoryTest {

    @Test
    public void beanFactoryTest(){

        BeanFactory beanFactory = new BeanFactory("beanFactory/beanFactory.xml");

        AreaBean areaBean = (AreaBean)beanFactory.getBean("areaBean");
        AreaBean areaBean1 = (AreaBean)beanFactory.getBean("areaBean");

        System.out.println(areaBean.hashCode());
        System.out.println(areaBean1.hashCode());
    }

}
