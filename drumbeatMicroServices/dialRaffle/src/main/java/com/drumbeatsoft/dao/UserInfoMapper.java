package com.drumbeatsoft.dao;

import com.drumbeatsoft.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    /**
     * 通过用户名查用户信息
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}
