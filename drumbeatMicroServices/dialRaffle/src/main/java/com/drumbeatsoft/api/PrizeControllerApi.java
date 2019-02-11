package com.drumbeatsoft.api;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.model.Prize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="奖品管理接口",description = "奖品信息管理")
public interface PrizeControllerApi {

    @ApiOperation("添加奖品")
    public ResponseResult save(Prize prize);
    @ApiOperation("删除奖品")
    public ResponseResult deleteById(String prizeId);
    @ApiOperation("更新奖品")
    public ResponseResult update(Prize prize);
    @ApiOperation("查找活动下的奖品")
    public ResponseResult findByActivityId(String activityId);
}
