package com.drumbeatsoft.dao;

import com.drumbeatsoft.model.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    /**
     * 保存活动信息
     * @param activity
     */
    void save(Activity activity);

    /**
     * 通过id查询活动信息
     * @param activityId
     * @return
     */
    Activity findById(String activityId);

    /**
     * 查所有
     * @return
     */
    List<Activity> findAll();

    /**
     * 通过公司id查询活动信息
     * @param companyId
     * @return
     */
    List<Activity> findByCompanyId(String companyId);
    /**
     * 通过id删除活动信息
     * @param activityId
     * @return
     */
    Integer deleteById(String activityId);

    /**
     * 根据id改
     * @param activityId
     * @return
     */
    Integer update(Activity activity);
    /**
     * 改变活动的开启关闭状态
     * @param status
     */
    void alterStatus(String activityId,int status);



}
