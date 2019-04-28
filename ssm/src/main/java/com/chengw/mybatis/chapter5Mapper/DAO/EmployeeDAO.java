package main.mybatis.chapter5Mapper.DAO;

import main.mybatis.chapter5Mapper.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO {
    Employee getEmployee(@Param("id") int id);
}
