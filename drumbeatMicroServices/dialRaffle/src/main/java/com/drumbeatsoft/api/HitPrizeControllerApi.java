package com.drumbeatsoft.api;

import com.drumbeatsoft.common.PageResponseResult;
import com.drumbeatsoft.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="中奖信息管理接口",description = "中奖信息管理")
public interface HitPrizeControllerApi {
    /**
     * 根据活动id和抽奖者id查询
     * @param activityId
     * @param accountId
     * @return
     */
    @ApiOperation("查询具体中奖人信息")
    ResponseResult findByActivityIdAndAccountId(String activityId, String accountId);

    /**
     * 分页查询本活动中奖人信息
     * @param activityId
     * @param page
     * @return
     */
    @ApiOperation("分页查询本活动中奖人信息")
    ResponseResult findByPage(String activityId, int page);
}
