package main.mybatis.chapter5Mapper.DAO;


import main.mybatis.chapter5Mapper.pojo.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDAO {

    Task getTask(@Param("id") int id);

}
