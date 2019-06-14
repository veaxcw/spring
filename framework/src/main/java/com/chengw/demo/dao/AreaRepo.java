package com.chengw.demo.dao;

import com.cbim.common.dao.BaseRepo;
import com.chengw.demo.po.AreaBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("areaRepo")
public interface AreaRepo extends BaseRepo<AreaBean,Long> {

    @Query(value = "select * from js_chengw_area where area_code like concat('%',?1,'%')",nativeQuery = true)
    List<AreaBean> findByAreaCode(String areaCode);

}
