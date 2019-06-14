package com.chengw.demo.service;

import com.cbim.common.exception.CoreExceptionEnum;
import com.cbim.common.exception.ServiceException;
import com.cbim.common.util.IdWorkerUtil;
import com.cbim.demo.DemoApplication;
import com.chengw.demo.dao.AreaRepo;
import com.chengw.demo.po.AreaBean;

import com.chengw.demo.utils.ConvertUtils;
import com.chengw.demo.utils.PoBeanUtils;
import com.chengw.demo.vo.AreaEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {DemoApplication.class})
@RunWith(SpringRunner.class)
@Service
@Slf4j
public class AreaService {

    @Resource
    private AreaRepo areaRepo;



    public List<AreaEntity> listArea(){
        List<AreaBean> areaBeans = areaRepo.findAll();

        List<AreaEntity> areaEntities = new ArrayList<>();

        for(AreaBean areaBean:areaBeans){
            AreaEntity area = new AreaEntity();
            //需要指定字段
            String fields = "id,areaCode,areaName".toLowerCase();

            ConvertUtils<AreaEntity,AreaBean> convertUtils = new ConvertUtils<>();
            convertUtils.entityToBean(area,areaBean,fields);

            areaEntities.add(area);
        }

        return areaEntities;

    }

    @Transactional
    public Long saveArea(AreaEntity areaEntity){
        AreaBean areaBean = PoBeanUtils.getAreaBeanInstance();

        String areaCode = areaEntity.getAreaCode();
        String areaName = areaEntity.getAreaName();
        String areaType = areaEntity.getAreaType();

        if (areaEntity.getId() == null || areaEntity.getId().equals("")) {
            log.info("add Area");
            areaBean.setId(IdWorkerUtil.getInstance().nextId());
            areaBean.setAreaCode(areaCode);
            areaBean.setAreaName(areaName);
            areaBean.setAreaType(areaType);
        }
        AreaBean saveAreaBean = areaRepo.save(areaBean);


        return saveAreaBean.getId();
    }

    public List<AreaEntity> findByAreaCode(String areaCode){

        List<AreaBean> areaBeans = areaRepo.findByAreaCode(areaCode);
        List<AreaEntity> areaEntities = new ArrayList<>();

        if(areaBeans == null)
            throw  new ServiceException(CoreExceptionEnum.E_KEY_EXIST);

        for(AreaBean areaBean:areaBeans){
            AreaEntity areaEntity = PoBeanUtils.getAreaEntityInstance();
            ConvertUtils<AreaEntity,AreaBean> convertUtils = new ConvertUtils<>();
            convertUtils.entityToBean(areaEntity,areaBean,null);
            areaEntities.add(areaEntity);
        }
        return areaEntities;
    }



}
