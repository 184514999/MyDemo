package com.drumbeatsoft.controller;

import com.drumbeatsoft.api.RandomPrizeControllerApi;
import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.model.Prize;
import com.drumbeatsoft.service.RandomPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@CrossOrigin
public class RandomPrizeController implements RandomPrizeControllerApi {
    @Autowired
    RandomPrizeService randomPrizeService;

    /**
     * 抽奖接口，重点权限控制
     * @param activityId
     * @param accountId
     * @return
     */
    @Override
    @GetMapping("/getRandomPrize/{activityId}/{accountId}")
    public ResponseResult  getRandomPrize(@PathVariable("activityId") String activityId,@PathVariable("accountId") String accountId) {

        ResponseResult<Prize> responseResult = randomPrizeService.getRandomPrize(activityId, accountId);

        return responseResult;
    }
}
