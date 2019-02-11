package com.drumbeatsoft.api;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.model.Activity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="活动管理接口",description = "活动信息管理")
public interface ActivityControllerApi {
    /**
     * 增加活动
     * @param activity
     * @return
     */
    @ApiOperation("添加活动")
    public ResponseResult save(Activity activity);

    /**
     *根据id删除
     * @param activityId
     */
    @ApiOperation("删除活动")
    public ResponseResult deleteById(String activityId);

    /**
     * 根据id改
     * @param activityId
     * @return
     */
    @ApiOperation("改变活动")
    public ResponseResult update(Activity activity);



    /**
     * 查所有
     * @return
     */
    @ApiOperation("查询所有活动")
    public ResponseResult findAll();
}
