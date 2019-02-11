package com.drumbeatsoft;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassWordEncoding {

    @Test
    public void Test01(){
        String passWord = "123456";
        String encode = new BCryptPasswordEncoder().encode(passWord);
        System.out.println(encode);

        boolean b = new BCryptPasswordEncoder().matches("123", "$2a$10$6Q8yoOq8YLN4b4F85pcX3e/CHjY5QiBm6pQk0slmxXOLSQowimJB.");
        System.out.println(b);
    }






}
