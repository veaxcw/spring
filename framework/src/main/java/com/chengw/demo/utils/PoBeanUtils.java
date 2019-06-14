package com.chengw.demo.utils;

import com.chengw.demo.po.AreaBean;
import com.chengw.demo.vo.AreaEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PoBeanUtils {

    private final static AreaBean AREA_BEAN_INSTANCE = new AreaBean();

    private final static AreaEntity AREA_ENTITY_INSTANCE = new AreaEntity();

    @Bean
    public static AreaBean getAreaBeanInstance(){
        return  AREA_BEAN_INSTANCE;
    }

    @Bean
    public static AreaEntity getAreaEntityInstance(){
        return AREA_ENTITY_INSTANCE;
    }

}
