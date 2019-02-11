package com.drumbeatsoft.dao;

import com.drumbeatsoft.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper {
    List<Role> findRoleByUserId(String userId);
}
