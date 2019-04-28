package main.mybatis.chapter5Mapper.DAO;

import main.mybatis.chapter5Mapper.pojo.MaleHealthForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaleHealthFormDAO {

    MaleHealthForm getMaleHealthForm(@Param("id") int id);
}
