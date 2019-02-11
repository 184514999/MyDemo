package com.drumbeatsoft.service;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.model.Prize;
import org.springframework.stereotype.Service;


public interface PrizeService {
    /**
     * 增
     * @param prize
     */
    ResponseResult save(Prize prize);

    /**
     * 根据id删
     * @param prizeId
     */
    ResponseResult deleteById(String prizeId);

    /**
     * 改
     * @param prize
     */
    ResponseResult update(Prize prize);

    /**
     * 根据活动id查
     * @param activityId
     */
    ResponseResult findByActivityId(String activityId);

    /**
     * 查所有
     */
    ResponseResult findAll();
}
