package com.drumbeatsoft.security;

import com.drumbeatsoft.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(-1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {



   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/login_error.html","/userlogin.html",
                            //放行swagger-ui
                            "/v2/api-docs", "/swagger-resources/configuration/ui",
                            "/swagger-resources","/swagger-resources/configuration/security",
                            "/swagger-ui.html","/webjars/**").permitAll()
                    .anyRequest().authenticated()   //其他所有资源都需要认证，登陆后访问
                    .antMatchers("/**").hasAuthority("ROLE_SUPER")
                    .and()
                .formLogin()
                    //指定登录页的路径
                    .loginPage("/userlogin")
                     //指定自定义form表单请求的路径
                    .loginProcessingUrl("/user/login")
                    .failureUrl("/login_error")
                    .defaultSuccessUrl("/success")
                     //必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
                     //这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
                     .permitAll();

        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http .csrf().disable();

        // 启用记住密码
       *//* http.authorizeRequests()
                .and()
                .rememberMe()
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                .key("111");*//*

    }
*/


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()//将PreflightRequest不做拦截
                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui",
                        "/swagger-resources","/swagger-resources/configuration/security",
                        "/swagger-ui.html","/webjars/**","/getRandomPrize/**").permitAll()
                .antMatchers("/**").hasAuthority("ROLE_SUPER")
                .anyRequest().authenticated()//其他的路径都是登录后即可访问
                    .and()
                .formLogin().loginPage("/login_page").successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write("{\"code\":\"0\",\"des\":\"登录成功\"}");
                out.flush();
                out.close();

            }
        })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"code\":\"1\",\"des\":\"登录失败\"}");
                        out.flush();
                        out.close();

                    }
                }).loginProcessingUrl("/user/login")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .cors()
                .and()
                .csrf().disable();






    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/static/**");

    }


    /**
     * 使用BCryptPasswordEncoder加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
