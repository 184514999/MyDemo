package com.drumbeatsoft;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.dao.ActivityMapper;
import com.drumbeatsoft.dao.HitPrizeMapper;
import com.drumbeatsoft.dao.PrizeMapper;
import com.drumbeatsoft.dao.UserInfoMapper;
import com.drumbeatsoft.model.Activity;
import com.drumbeatsoft.model.HitPrize;
import com.drumbeatsoft.model.Prize;
import com.drumbeatsoft.model.UserInfo;
import com.drumbeatsoft.service.HitPrizeService;
import com.drumbeatsoft.service.RandomPrizeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    PrizeMapper prizeMapper;
    @Autowired
    RandomPrizeService prizeService;
    @Autowired
    HitPrizeMapper hitPrizeMapper;
    @Autowired
    HitPrizeService hitPrizeService;

    @Test
    public void test11(){
        hitPrizeService.findByPage("12da2a0c6cfd44e297cfb5a18328b688",1);
    }

    @Test
    public void test10(){
        Activity activity = activityMapper.findById("545614516456546");
        System.out.println(activity);
    }

    @Test
    public void Test09() throws InterruptedException {

        System.out.println(new Date().getTime());
        Thread.sleep(1000);

        System.out.println(new Date().getTime());
    }


    @Test
    public void test02() {
        Activity activity = new Activity();
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        activity.setActivityId(uuid);
        activity.setTitle("一个测试用的活动标题");
        activity.setStartTime(new Date());
        activity.setEndTime(new Date());
        activity.setTimes(3);
        activity.setCreateUserId(uuid);
        activity.setCreateUserName("小红");
        activity.setCompanyId(uuid);
        activity.setCompanyName("oppo");


        activityMapper.save(activity);

    }

    @Test
    public void test03() {
        Prize prize = new Prize();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        prize.setPrizeId(uuid);
        prize.setCounts(3);
        prize.setName("一等奖");
        prizeMapper.save(prize);
    }


    @Test
    public void test04(){
        UserInfo userInfo = userInfoMapper.findByUsername("zhangsan");
        System.out.println(userInfo);

    }

    @Test
    public void Test05(){
        List<Prize> prizes = prizeMapper.findPrizeByActivityId("12da2a0c6cfd44e297cfb5a18328b688");
        for (Prize prize : prizes) {
            System.out.println(prize);
        }
    }

    @Test
    public void test006(){
        ResponseResult responseResult = prizeService.getRandomPrize("12da2a0c6cfd44e297cfb5a18328b688","135b7e3ed4ce44cdb42ccee490bfcf66");
        System.out.println("==========================================");
        System.out.println(((Prize)(responseResult.getList().get(0))).getName());
    }

    @Test
    public void test06(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            ResponseResult responseResult = prizeService.getRandomPrize("12da2a0c6cfd44e297cfb5a18328b688","1818fa9834584aeb8da3dd298774767a");
            System.out.println("================第"+i+"次==========================");
        System.out.println(((Prize)(responseResult.getList().get(0))).getName());
        System.out.println();
        System.out.println();

        }
        long end = System.currentTimeMillis();

        long time = end - start;
        System.out.println(time);
    }

    @Test
    public void Test07(){
        Activity activity = activityMapper.findById("12da2a0c6cfd44e297cfb5a18328b688");

        System.out.println(activity);
    }


    @Test
    public void Test08(){

        List<HitPrize> hitPrizes = hitPrizeMapper.findByActivityIdAndAccountId("12d12a0c6cfd44e297cfb5a18328b688", "1818fa9834584aeb8da3dd298774767a");

        System.out.println(hitPrizes.size()+"============================");
        for (HitPrize hitPrize : hitPrizes) {
            System.out.println(hitPrize);
        }
    }


}
