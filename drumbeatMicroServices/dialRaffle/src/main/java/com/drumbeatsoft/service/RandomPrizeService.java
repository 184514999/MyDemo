package com.drumbeatsoft.service;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.model.Prize;

public interface RandomPrizeService {

    ResponseResult<Prize> getRandomPrize(String activityId,String accountId);
}
