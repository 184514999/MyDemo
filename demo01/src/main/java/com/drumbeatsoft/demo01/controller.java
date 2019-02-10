package com.drumbeatsoft.demo01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
    @RequestMapping("/h")
    public String test(){
        return "/login";
    }
}
