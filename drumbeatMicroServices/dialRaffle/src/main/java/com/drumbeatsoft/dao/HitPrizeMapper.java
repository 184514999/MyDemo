package com.drumbeatsoft.dao;

import com.drumbeatsoft.model.HitPrize;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface HitPrizeMapper {
    /**
     * 根据活动id和抽奖者账户id查询中将记录
     * @param activityId
     * @param accountId
     * @return
     */
    List<HitPrize> findByActivityIdAndAccountId(String activityId,String accountId);

    /**
     * 保存数据
     * @param hitPrize
     */
    void save(HitPrize hitPrize);

    /**
     * 分页查询中奖信息
     * @param activityId
     * @return
     */
    Page<HitPrize> findByPage(String activityId);

}
