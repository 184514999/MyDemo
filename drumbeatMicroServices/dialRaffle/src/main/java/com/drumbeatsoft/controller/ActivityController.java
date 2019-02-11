package com.drumbeatsoft.controller;

import com.drumbeatsoft.api.ActivityControllerApi;
import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.model.Activity;
import com.drumbeatsoft.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/activity")
public class ActivityController implements ActivityControllerApi {
    @Autowired
    private ActivityService activityService;

    /**
     * 保存活动信息
     * @param activity
     * @return
     */
    @Override
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody Activity activity) {
        ResponseResult responseResult = activityService.save(activity);
        return responseResult;
    }

    /**
     * 删除活动信息
     */
    @Override
    @DeleteMapping("/deleteById/{activityId}")
    public ResponseResult deleteById(@PathVariable("activityId") String activityId) {
        ResponseResult responseResult = activityService.deleteById(activityId);
        return responseResult;
    }

    /**
     * 根据更改活动信息
     * @param activityId
     * @return
     */
    @Override
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody Activity activity) {
        ResponseResult responseResult = activityService.update(activity);
        return responseResult;
    }


    /**
     * 查找全部活动信息
     * @return
     */
    @Override
    @RequestMapping("/findAll")
    public ResponseResult findAll() {
        ResponseResult responseResult = activityService.findAll();
        return responseResult;
    }
}
