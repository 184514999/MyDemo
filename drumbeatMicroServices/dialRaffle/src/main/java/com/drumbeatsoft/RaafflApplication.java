package com.drumbeatsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2    //开启swaggerUI支持
@ComponentScan(basePackages = {"com.drumbeatsoft"})
@EnableAutoConfiguration
@EnableWebSecurity      //开启security支持
//@EnableWebMvc
//@ImportResource(locations = {"classpath:spring-security.xml"})    //用于加载xml配置文件
public class RaafflApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaafflApplication.class,args);
    }


}
