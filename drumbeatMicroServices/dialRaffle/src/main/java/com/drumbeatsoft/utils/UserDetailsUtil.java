package com.drumbeatsoft.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsUtil {
    static UserDetails userDetails;
    static {
         userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    /**
     * 获取用户名
     * @return
     */
    public static String getUsername(){
        return userDetails.getUsername();
    }




}
