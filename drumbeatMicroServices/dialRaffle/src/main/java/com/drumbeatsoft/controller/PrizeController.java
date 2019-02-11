package com.drumbeatsoft.controller;

import com.drumbeatsoft.api.PrizeControllerApi;
import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.model.Prize;
import com.drumbeatsoft.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/prize")
public class PrizeController implements PrizeControllerApi {
    @Autowired
    PrizeService prizeService;

    @Override
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody Prize prize) {
        ResponseResult responseResult = prizeService.save(prize);
        return responseResult;
    }

    @Override
    @RequestMapping("/deleteById/{prizeId}")
    public ResponseResult deleteById(@PathVariable("prizeId") String prizeId) {
        ResponseResult responseResult = prizeService.deleteById(prizeId);
        return responseResult;
    }

    @Override
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody Prize prize) {
        ResponseResult responseResult = prizeService.update(prize);
        return responseResult;
    }

    @Override
    @RequestMapping("/findByActivityId/{activityId}")
    public ResponseResult findByActivityId(@PathVariable("activityId") String activityId) {
        ResponseResult responseResult = prizeService.findByActivityId(activityId);
        return responseResult;
    }
}
