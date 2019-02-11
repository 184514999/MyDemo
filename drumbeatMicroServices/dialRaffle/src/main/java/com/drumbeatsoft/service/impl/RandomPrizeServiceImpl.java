package com.drumbeatsoft.service.impl;

import com.drumbeatsoft.common.ResponseResult;
import com.drumbeatsoft.dao.ActivityMapper;
import com.drumbeatsoft.dao.HitPrizeMapper;
import com.drumbeatsoft.dao.PrizeMapper;
import com.drumbeatsoft.model.Activity;
import com.drumbeatsoft.model.HitPrize;
import com.drumbeatsoft.model.Prize;
import com.drumbeatsoft.service.RandomPrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Transactional
public class RandomPrizeServiceImpl implements RandomPrizeService {
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    PrizeMapper prizeMapper;
    @Autowired
    HitPrizeMapper hitPrizeMapper;

    private Lock lock = new ReentrantLock();// 锁对象
    /**
     * 抽取奖品
     *
     * @param activityId
     * @return
     */
    @Override
    public ResponseResult getRandomPrize(String activityId, String accountId) {
        try {

            //判断活动状态
            Activity activity = activityMapper.findById(activityId);
            if (activity.getStatus() != 2){
                return new ResponseResult(1,"不在可抽奖时间");
            }
            List<Prize> list = new ArrayList<>();
            //查询奖品是否可重复抽取
            boolean multiple = activityMapper.findById(activityId).isMultiple();

            if (!multiple) {
                //不可重复抽取，查询账户是否有本次活动中奖纪录
                List<HitPrize> hitPrizes = hitPrizeMapper.findByActivityIdAndAccountId(activityId, accountId);
                //有中奖纪录，返回未中奖结果
                if (hitPrizes.size() > 0) {
                    Prize prize = new Prize();
                    prize.setName("您已经中过奖了~~~");
                    list.add(prize);
                    return new ResponseResult(1,"此用户已经中过奖了",list);
                }
            }

            lock.lock();            // 得到锁

            //取出数据库中奖品信息
            List<Prize> prizes = prizeMapper.findPrizeByActivityId(activityId);

            //判断是否还有奖品（包括谢谢惠顾）
            if (prizes.size() <= 0) {
                Prize prize = new Prize();
                prize.setName("奖品发完，下次再来吧~~~");

               /* prize.setCounts(0);
                prize.setLevel(0);
                prize.setWeight(0);

                prize.setSomething(false);
                list.add(prize);*/

             //   return new ResponseResult(1,"设置的奖品被抽完了",list);
                return new ResponseResult(1,"设置的奖品被抽完了");
            }
            //进行抽奖
            int selected = getPrizeIndex(prizes);
            //被抽中的奖品
            Prize prize = prizes.get(selected);
            //将被抽中的数据从数据库中-1
            prize.setCounts(prize.getCounts() - 1);
            prizeMapper.updateCounts(prize);

            //判断是否中奖
            if (prize.isSomething()) {
                //将中奖信息存储在hit_prize中
                saveHitPrize(activityId, accountId, prize);
            }

            list.add(prize);
            return new ResponseResult(0,"抽取奖品成功",list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult(-1,"服务器异常"+e.toString(),null);
        }finally {
            lock.unlock();// 释放锁
        }
    }


    /**
     * 根据Math.random()产生一个double型的随机数，判断每个奖品出现的概率
     *
     * @param prizes
     * @return random：奖品列表prizes中的序列（prizes中的第random个就是抽中的奖品）
     */
    public int getPrizeIndex(List<Prize> prizes) {
        int random = -1;
        try {
            //计算总权重
            double sumWeight = 0;
            for (Prize p : prizes) {
                sumWeight += p.getWeight();
            }

            //产生随机数
            double randomNumber;
            randomNumber = Math.random();

            //根据随机数在所有奖品分布的区域并确定所抽奖品
            double d1 = 0;
            double d2 = 0;
            for (int i = 0; i < prizes.size(); i++) {
                d2 += Double.parseDouble(String.valueOf(prizes.get(i).getWeight())) / sumWeight;
                if (i == 0) {
                    d1 = 0;
                } else {
                    d1 += Double.parseDouble(String.valueOf(prizes.get(i - 1).getWeight())) / sumWeight;
                }
                if (randomNumber >= d1 && randomNumber <= d2) {
                    random = i;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("生成抽奖随机数出错，出错原因：" + e.getMessage());
        }
        return random;
    }

    /**
     * 将中奖信息储存至hit_prize表中
     *
     * @param activityId
     * @param accountId
     * @param prize
     */
    public void saveHitPrize(String activityId, String accountId, Prize prize) {
        HitPrize hitPrize = new HitPrize();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        hitPrize.setId(uuid);
        hitPrize.setActivityId(activityId);
        hitPrize.setAccountId(accountId);
        hitPrize.setPrizeId(prize.getPrizeId());
        hitPrize.setPrizeName(prize.getName());

        //调用dao层
        hitPrizeMapper.save(hitPrize);

    }
}
