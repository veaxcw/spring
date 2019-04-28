package main.mybatis.chapter5Mapper.DAO;

import main.mybatis.chapter5Mapper.pojo.FemaleHealthForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FemaleHealthFormDAO {
    FemaleHealthForm getFemaleHealthForm(@Param("id") int id);
}
