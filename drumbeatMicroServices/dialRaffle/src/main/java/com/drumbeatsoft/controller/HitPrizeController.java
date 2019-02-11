package com.drumbeatsoft.controller;

import com.drumbeatsoft.api.HitPrizeControllerApi;
import com.drumbeatsoft.common.PageResponseResult;
import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.service.HitPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/hitPrize")
public class HitPrizeController implements HitPrizeControllerApi {
    @Autowired
    HitPrizeService hitPrizeService;

    /**
     * 查询具体中奖人信息
     * @param activityId
     * @param accountId
     * @return
     */
    @Override
    @RequestMapping("/findByActivityIdAndAccountId/{activityId}/{accountId}")
    public ResponseResult findByActivityIdAndAccountId(@PathVariable("activityId") String activityId, @PathVariable("accountId") String accountId) {
        ResponseResult responseResult = hitPrizeService.findByActivityIdAndAccountId(activityId, accountId);
        return responseResult;
    }

    /**
     * 分页查询本活动中奖人信息
     * @param activityId
     * @param page
     * @return
     */
    @Override
    @RequestMapping("/findByPage/{activityId}/{page}")
    public ResponseResult findByPage(@PathVariable("activityId") String activityId, @PathVariable("page") int page) {
        ResponseResult ResponseResult = hitPrizeService.findByPage(activityId, page);
        return ResponseResult;
    }
}
