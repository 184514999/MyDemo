package com.drumbeatsoft.common;


import com.drumbeatsoft.dao.ActivityMapper;
import com.drumbeatsoft.model.Activity;
import com.drumbeatsoft.utils.ScheduledExecutorServiceUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AlertStatusThread implements Runnable {

    ActivityMapper activityMapper;

    private String activityId;


    public AlertStatusThread(ActivityMapper activityMapper, String activityId) {
        this.activityMapper = activityMapper;
        this.activityId = activityId;
    }

    public AlertStatusThread(String activityId) {
        this.activityId = activityId;
    }

    @Override
    public void run() {
        boolean b = true;
        while (true){
            Activity activity = activityMapper.findById(activityId);


            if (activity == null){
               b = false;
               break;
            }

            Date startTime = activity.getStartTime();
            Date endTime = activity.getEndTime();

            if (startTime == null || endTime == null){
                try {
                    //每30秒查询一次数据库看最新时间信息
                    Thread.sleep(1000*30);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (startTime.getTime() - new Date().getTime() <=1000*60*3){
                //当距离活动开始还有3分钟时，将活动状态更改为1（未开始但不可再改变）
                activityMapper.alterStatus(activityId,1);
                break;
            }
            try {
                //每30秒查询一次数据库看最新时间信息
                Thread.sleep(1000*30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        if (b){
        //开启计时器
        //此service在util对象里为单例模式
        ScheduledExecutorService service = ScheduledExecutorServiceUtil.getService();
        //获取数据库时间信息
        Activity activity = activityMapper.findById(activityId);
        Date startTime = activity.getStartTime();
        Date endTime = activity.getEndTime();

        //活动开始时间计时器
        long delayToStart = startTime.getTime() - new Date().getTime();
        //设定延迟执行
        service.schedule(new Runnable() {
            @Override
            public void run() {
                activityMapper.alterStatus(activityId, 2);
            }
        }, delayToStart, TimeUnit.MILLISECONDS);

        //活动关闭计时器
        long delayToEnd = endTime.getTime() - new Date().getTime();

        //设定延迟执行
        service.schedule(new Runnable() {
            @Override
            public void run() {
                activityMapper.alterStatus(activityId, 3);
            }
        }, delayToEnd, TimeUnit.MILLISECONDS);
        }
    }
}
