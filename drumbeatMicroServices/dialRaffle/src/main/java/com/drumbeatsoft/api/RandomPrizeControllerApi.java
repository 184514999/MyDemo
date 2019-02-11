package com.drumbeatsoft.api;

import com.drumbeatsoft.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.ResponseBody;
@Api(value="转盘抽奖奖品接口",description = "奖品信息管理")
public interface RandomPrizeControllerApi {
    @ApiOperation("抽取一个奖品")
    public ResponseResult getRandomPrize(String activityId,String AccountId);
}
