package com.drumbeatsoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void test01(){
    BoundListOperations<String, String> mylist = stringRedisTemplate.boundListOps("mylist");
        int i = 1;

       while (true){

           String s = mylist.leftPop(10000, TimeUnit.MILLISECONDS);
           if (s == null){
               continue;
           }
           System.out.println(s);
           /*mylist.leftPush(String.valueOf(i));
           System.out.println(i++);
           if (i == 20){
               break;
           }*/
       }


    }
}
