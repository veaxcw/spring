package com.chengw.mybatis.chapter3Core.mapper;

import com.chengw.mybatis.chapter3Core.pojo.Role;
import main.mybatis.chapter3Core.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
     Role getRole(int id);
     List<Role> getAll(@Param("roleName") String roleName, @Param("note") String note);
     int insertRole(Role role);
     int deleteRole(int id);
     int updateRole(Role role);
     Role findRoleByRoleName(String roleName);
     Role findRoleByNote(String note);


}
