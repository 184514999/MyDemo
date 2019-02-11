package com.drumbeatsoft.service;

import com.drumbeatsoft.common.ResponseResult;

public interface HitPrizeService {
    /**
     * 根据活动id和抽奖者账户id查询中将记录
     * @param activityId
     * @param accountId
     * @return
     */
    ResponseResult findByActivityIdAndAccountId(String activityId,String accountId);

    /**
     * 根据活动id分页查询中奖信息
     * @param activityId
     * @return
     */
    ResponseResult findByPage(String activityId,int page);
}
