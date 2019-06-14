package com.chengw.mybatis.chapter5Mapper.DAO;

import main.mybatis.chapter5Mapper.pojo.WorkCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkCardDAO {

    WorkCard getWorkCardByEmpId(@Param("empId") int empId);

}
