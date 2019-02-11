package com.drumbeatsoft.service;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.model.Activity;

import java.util.Date;

public interface ActivityService {

    /**
     * 增
     * @param activity
     * @return
     */
    public ResponseResult save(Activity activity);

    /**
     * 根据id查
     * @param activityId
     * @return
     */
    public ResponseResult findById(String activityId);

    /**
     * 查所有
     * @return
     */
    public ResponseResult findAll();

    /**
     * 根据id删
     * @param activityId
     * @return
     */
    public ResponseResult deleteById(String activityId);

    /**
     * 改
     * @param activity
     * @return
     */
    public ResponseResult update(Activity activity);;


}
