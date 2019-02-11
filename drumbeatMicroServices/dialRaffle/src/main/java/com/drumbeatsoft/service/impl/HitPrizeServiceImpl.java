package com.drumbeatsoft.service.impl;

import com.drumbeatsoft.common.PageResponseResult;
import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.dao.HitPrizeMapper;
import com.drumbeatsoft.model.HitPrize;
import com.drumbeatsoft.service.HitPrizeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HitPrizeServiceImpl implements HitPrizeService {
    @Autowired
    HitPrizeMapper hitPrizeMapper;
    @Override
    public ResponseResult findByActivityIdAndAccountId(String activityId, String accountId) {
        try {
            List<HitPrize> hitPrizes = hitPrizeMapper.findByActivityIdAndAccountId(activityId, accountId);
            return new ResponseResult(0,"查询中奖信息成功",hitPrizes);
        }catch (Exception e){
            return new ResponseResult(1,"查询中奖信息失败");
        }
    }

    @Override
    public ResponseResult findByPage(String activityId,int page) {
        try {
            PageHelper.startPage(page,9);
            Page<HitPrize> pageList = hitPrizeMapper.findByPage(activityId);
            List<HitPrize> hitPrizes = pageList.getResult();
            long total = pageList.getTotal();
            return new PageResponseResult(0,"分页查询中奖信息成功",hitPrizes,total);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(1,"分页查询中奖信息失败");
        }

    }
}
