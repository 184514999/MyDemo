package com.drumbeatsoft.security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;


/**
 * 解决跨域问题
 */
@Configuration
@AutoConfigureBefore(SecurityConfig.class)
public class MyMvcConfigurer implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry){

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
