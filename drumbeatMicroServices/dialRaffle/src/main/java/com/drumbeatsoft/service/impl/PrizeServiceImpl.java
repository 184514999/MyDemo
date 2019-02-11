package com.drumbeatsoft.service.impl;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.dao.ActivityMapper;
import com.drumbeatsoft.dao.PrizeMapper;
import com.drumbeatsoft.dao.UserInfoMapper;
import com.drumbeatsoft.model.Activity;
import com.drumbeatsoft.model.Prize;
import com.drumbeatsoft.model.UserInfo;
import com.drumbeatsoft.service.PrizeService;
import com.drumbeatsoft.utils.UserDetailsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrizeServiceImpl implements PrizeService {
    @Autowired
    PrizeMapper prizeMapper;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    public ResponseResult save(Prize prize) {
        try {
            //判断活动状态
            Activity activity = activityMapper.findById(prize.getActivityId());
            int status = activity.getStatus();
            if (status != 0){
                return new ResponseResult(1,"活动信息已不可更改");
            }
            //生成uuid
            String p_uuid = UUID.randomUUID().toString().replaceAll("-", "");
            prize.setPrizeId(p_uuid);
            //补全奖品列表信息
            String username = UserDetailsUtil.getUsername();
            UserInfo userInfo = userInfoMapper.findByUsername(username);
            prize.setCreateUserId(userInfo.getId());
            prize.setCreateUserName(userInfo.getName());
            prize.setCompanyId(userInfo.getCompanyId());


            prizeMapper.save(prize);
            return new ResponseResult(0,"保存奖品信息成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(1,"保存奖品信息失败");
        }

    }

    @Override
    public ResponseResult deleteById(String prizeId) {
        try {
            //判断当前用户是否有权限
            if (!auth(prizeId)){
                return new ResponseResult(1,"您无权操作该资源");
            }
            //判断活动状态
            int status = getActivityStatus(prizeId);
            if (status != 0){
                return new ResponseResult(1,"活动信息已不可更改");
            }
            prizeMapper.deleteById(prizeId);
            return new ResponseResult(0,"删除奖品信息成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(1,"删除奖品信息失败");
        }


    }

    @Override
    public ResponseResult update(Prize prize) {
        try {
            //判断当前用户是否有权限
            if (!auth(prize.getPrizeId())){
                return new ResponseResult(1,"您无权操作该资源");
            }
            //判断活动状态
            int status = getActivityStatus(prize.getPrizeId());
            if (status != 0){
                return new ResponseResult(1,"活动信息已不可更改");
            }
            //补全更新人信息
            String username = UserDetailsUtil.getUsername();
            UserInfo userInfo = userInfoMapper.findByUsername(username);
            prize.setModifyUserId(userInfo.getId());
            prize.setModifyUserName(userInfo.getName());

            prizeMapper.update(prize);
            return new ResponseResult(0,"更新奖品信息成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(1,"更新奖品信息失败");
        }
    }

    @Override
    public ResponseResult findByActivityId(String activityId) {
            try {
                List<Prize> prizes = prizeMapper.findAllPrizeByActivityId(activityId);
                ResponseResult<Prize> responseResult = new ResponseResult<>(0, "查询奖品信息成功");
                responseResult.setList(prizes);
                return responseResult;
            }catch (Exception e){
                return new ResponseResult(1,"查询奖品信息失败");
            }
    }

    /**
     * 此接口是程序员用的
     * @return
     */
    @Override
    public ResponseResult findAll() {
        try {
            List<Prize> prizes = prizeMapper.findAll();
            ResponseResult<Prize> responseResult = new ResponseResult<>(0, "查询所有奖品信息成功");
            responseResult.setList(prizes);
            return responseResult;
        }catch (Exception e){
            return new ResponseResult(1,"查询所有奖品信息失败");
        }
    }


    /**
     * 查询奖品所属活动状态
     * @param prizeId
     * @return
     */
    public int getActivityStatus(String prizeId){
        Prize prize = prizeMapper.findById(prizeId);
        Activity activity = activityMapper.findById(prize.getActivityId());
        int status = activity.getStatus();
        return status;
    }

    /**
     * 判断用户对奖品的权限
     */
    public boolean auth(String prizeId){
        try {
            String username = UserDetailsUtil.getUsername();
            UserInfo userInfo = userInfoMapper.findByUsername(username);
            String companyId1 = userInfo.getCompanyId();

            Prize prize = prizeMapper.findById(prizeId);
            String companyId = prize.getCompanyId();
            if (companyId !=null && companyId1!= null && companyId.equals(companyId1)){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
