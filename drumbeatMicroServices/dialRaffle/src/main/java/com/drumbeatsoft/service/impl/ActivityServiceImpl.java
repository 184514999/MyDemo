package com.drumbeatsoft.service.impl;

import com.drumbeatsoft.common.AlertStatusThread;
import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.dao.ActivityMapper;
import com.drumbeatsoft.dao.UserInfoMapper;
import com.drumbeatsoft.model.Activity;
import com.drumbeatsoft.model.UserInfo;
import com.drumbeatsoft.service.ActivityService;
import com.drumbeatsoft.utils.ScheduledExecutorServiceUtil;
import com.drumbeatsoft.utils.UserDetailsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    UserInfoMapper userInfoMapper;



    /**
     * 增
     *
     * @param activity
     * @return
     */
    @Override
    public ResponseResult save(Activity activity) {
        ResponseResult<Activity> responseResult = new ResponseResult<>();
        try {
            //生成uuid
            String a_uuid = UUID.randomUUID().toString().replaceAll("-", "");
            activity.setActivityId(a_uuid);
            //补全用户信息
            UserInfo userInfo = userInfoMapper.findByUsername(UserDetailsUtil.getUsername());
            activity.setCreateUserId(userInfo.getId());
            activity.setCreateUserName(userInfo.getName());
            activity.setCompanyId(userInfo.getCompanyId());
            activity.setCompanyName(userInfo.getCompanyName());


            //定时器设置
            Date startTime = activity.getStartTime();
            Date endTime = activity.getEndTime();
            if (startTime == null || endTime == null) {
                //什么都不做
            } else if (endTime.getTime() - startTime.getTime() <= 0 || startTime.getTime() - System.currentTimeMillis() < 1000 * 60 * 3) {
                //活动必须提前3分钟发布，开始时间不能小于结束时间
                responseResult.setCode(1);
                responseResult.setDesc("活动时间设置不合理");
                return responseResult;
            }

            activityMapper.save(activity);

            //开启线程计时器
            new Thread(new AlertStatusThread(activityMapper,activity.getActivityId())).start();

            responseResult.setCode(0);
            responseResult.setDesc("增加活动成功");
            return responseResult;
        } catch (Exception e) {
            responseResult.setCode(1);
            responseResult.setDesc("增加活动失败");
            return responseResult;
        }
    }

    /**
     * 根据id查
     *
     * @param activityId
     * @return
     */
    @Override
    public ResponseResult findById(String activityId) {
        ResponseResult<Activity> responseResult = new ResponseResult<>();
        try {
            Activity activity = activityMapper.findById(activityId);
            ArrayList<Activity> activities = new ArrayList<>();
            activities.add(activity);
            responseResult.setCode(0);
            responseResult.setDesc("根据id查询活动成功");
            responseResult.setList(activities);
            return responseResult;
        } catch (Exception e) {
            responseResult.setCode(1);
            responseResult.setDesc("根据id查询活动失败");
            return responseResult;
        }

    }

    /**
     * 查所有
     *
     * @return
     */
    @Override
    public ResponseResult findAll() {
        ResponseResult<Activity> responseResult = new ResponseResult<>();
        try {
            UserInfo userInfo = userInfoMapper.findByUsername(UserDetailsUtil.getUsername());
            //通过公司id查询，用户只能查询本公司活动信息
            List<Activity> activities = activityMapper.findByCompanyId(userInfo.getCompanyId());

            responseResult.setCode(0);
            responseResult.setDesc("查询所有活动信息成功");
            responseResult.setList(activities);
            return responseResult;
        } catch (Exception e) {
            responseResult.setCode(1);
            responseResult.setDesc("查询所有活动失败");
            return responseResult;
        }
    }

    /**
     * 根据id删
     *
     * @param activityId
     * @return
     */
    @Override
    public ResponseResult deleteById(String activityId) {
        ResponseResult<Activity> responseResult = new ResponseResult<>();
        try {
            Activity activity = activityMapper.findById(activityId);
            //活动未开始，可以删除
            if (activity.getStatus() == 0) {
                Integer integer = activityMapper.deleteById(activityId);
                responseResult.setCode(0);
                responseResult.setDesc("根据id删除活动信息成功");
                return responseResult;
            }
            //活动已开始或结束不可删除
            responseResult.setCode(1);
            responseResult.setDesc("活动已不可删除");
            return responseResult;
        } catch (Exception e) {
            responseResult.setCode(1);
            responseResult.setDesc("根据id删除活动信息失败");
            return responseResult;
        }
    }

    /**
     * 改
     *
     * @param activity
     * @return
     */
    @Override
    public ResponseResult update(Activity activity) {
        ResponseResult<Activity> responseResult = new ResponseResult<>();
        try {
            Activity activity1 = activityMapper.findById(activity.getActivityId());
            //活动未开始可以更改
            if (activity1.getStatus() == 0) {
                //不全用户信息
                String username = UserDetailsUtil.getUsername();
                UserInfo userInfo = userInfoMapper.findByUsername(username);
                activity.setModifyUserId(userInfo.getId());
                activity.setModifyUserName(userInfo.getName());

                Integer integer = activityMapper.update(activity);
                responseResult.setCode(0);
                responseResult.setDesc("更改活动信息成功");
                return responseResult;
            }
            //活动已开始或结束
            responseResult.setCode(1);
            responseResult.setDesc("活动已不可更改");
            return responseResult;
        } catch (Exception e) {
            responseResult.setCode(1);
            responseResult.setDesc("更改活动信息失败");
            return responseResult;
        }
    }


}
