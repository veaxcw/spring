package main.mybatis.chapter5Mapper.DAO;

import main.mybatis.chapter5Mapper.pojo.EmployeeTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTaskDAO {
    EmployeeTask getEmployeeTaskByEmpId(@Param("empId") int empId);
}
