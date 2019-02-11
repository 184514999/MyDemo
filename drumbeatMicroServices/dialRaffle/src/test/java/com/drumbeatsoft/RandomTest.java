package com.drumbeatsoft;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.model.Prize;
import com.drumbeatsoft.service.PrizeService;
import com.drumbeatsoft.service.RandomPrizeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RandomTest {
    @Autowired
    RandomPrizeService randomPrizeService;

    @Test
    public void testRandom(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ResponseResult<Prize> responseResult = randomPrizeService.getRandomPrize("ae76eff6caf34d9aa8c54f29df52ad05", "我是哈哈");
                    List<Prize> prizes = responseResult.getList();

                    System.out.println("我是哈哈   "+prizes.get(0).getName());

                }
            }
        }).start();


        for (int i = 0; i < 10; i++) {
            ResponseResult<Prize> responseResult = randomPrizeService.getRandomPrize("ae76eff6caf34d9aa8c54f29df52ad05", "我是嘿嘿");
            List<Prize> prizes = responseResult.getList();

            System.out.println("我是嘿嘿   "+prizes.get(0).getName());

        }
    }
}
