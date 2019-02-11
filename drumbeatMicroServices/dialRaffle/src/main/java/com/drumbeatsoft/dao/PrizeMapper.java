package com.drumbeatsoft.dao;

import com.drumbeatsoft.model.Prize;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrizeMapper {
    /**
     * 保存奖品信息
     * @param prize
     */
    void save(Prize prize);

    /**
     * 根据id删除奖品信息
     * @param prizeId
     */
    void deleteById(String prizeId);
    /**
     * 更改奖品剩余数量信息
     * @param prize
     */
    void updateCounts(Prize prize);

    /**
     * 更新奖品信息
     * @param prize
     */
    void update(Prize prize);

    /**
     * 查询全部奖品信息
     * @return
     */
    List<Prize> findAll();

    /**
     * 通过活动Id查询剩余数大于0奖品信息
     * @param activityId
     * @return
     */
    List<Prize> findPrizeByActivityId(String activityId);

    /**
     * 通过活动Id查询所有奖品信息
     * @param activityId
     * @return
     */
    List<Prize> findAllPrizeByActivityId(String activityId);

    /**
     * 通过id查询
     * @param prizeId
     * @return
     */
    Prize findById(String prizeId);



}
