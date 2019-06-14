package com.chengw.demo.restCtrl;

import com.cbim.common.exception.ServiceException;
import com.cbim.common.vo.MessageEntity;
import com.chengw.demo.common.IDEntity;
import com.chengw.demo.service.AreaService;
import com.chengw.demo.utils.RestUtils;
import com.chengw.demo.vo.AreaEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/demo")
@Api(tags = "demo")
@Slf4j
public class AreaRestCtrl {
    @Resource
    private AreaService areaService;

    @RequestMapping(value = "/list/Area",produces = "application/json",method = RequestMethod.POST)
    @ApiOperation(value = "地区列表",notes = "地区列表")
    public List<AreaEntity> listArea(){

        return areaService.listArea();
    }

    @RequestMapping(value = "/list/Area/save",produces = "application/json",method = RequestMethod.POST)
    @ApiOperation(value = "保存地区",notes = "保存地区")
    public MessageEntity<String> saveArea(@RequestBody AreaEntity areaEntity){

        try {
            log.info("保存区域");
            Long areaId = areaService.saveArea(areaEntity);
            return RestUtils.success(new IDEntity(areaId.toString()));
        } catch (ServiceException se) {
            se.printStackTrace();
            return RestUtils.fail(se);
        }catch (Exception e){
            e.printStackTrace();
            return RestUtils.fail(e);
        }
    }

    @RequestMapping(value = "/list/Area/find",produces = "application/json",method = RequestMethod.POST)
    @ApiOperation(value = "查询区域",notes = "查询区域")
    public List<AreaEntity> findArea(@RequestBody AreaEntity areaEntity){
        String areaCode = areaEntity.getAreaCode();

        log.info("查询区域");
        List<AreaEntity> areaEntities = areaService.findByAreaCode(areaCode);
        return areaEntities;

    }

}
