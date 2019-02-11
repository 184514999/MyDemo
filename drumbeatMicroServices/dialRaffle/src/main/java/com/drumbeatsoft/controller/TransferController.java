package com.drumbeatsoft.controller;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.utils.UserDetailsUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 该类起到转发作用，主要解决springboot工程无法直接访问静态资源问题
 */
@Controller
@RequestMapping("/")
public class TransferController {

    /**
     * 返回登陆页面
     * @return
     */
    @RequestMapping("/userlogin")
    public String login(){
        return "userlogin";
    }


    /**
     * 登陆失败返回页面
     * @return
     */
    @RequestMapping("/login_error")
    public String loginError(){
        return "login_error";
    }

    /**
     * 未登陆，跳转登陆页面
     * @return
     */
    @RequestMapping("/login_page")
    @ResponseBody
    public ResponseResult success(){
        System.out.println("返回登陆页面");
        ResponseResult<Object> responseResult = new ResponseResult<>(2, "未登陆，跳转登陆页面");
        return responseResult;
    }

    /**
     * 返回发布活动页面
     * @return
     */
    @RequestMapping("/post_activity")
    public String postActivity(){
        return "post_activity";
    }

    /**
     * 返回抽奖页面
     * @return
     */
    @RequestMapping("/get_prize")
    public String getPrize(){
        return "get_prize";
    }

    @RequestMapping("/swagger-ui")
    public String getSwaggerUI(){
        return "swagger-ui";
    }
}
