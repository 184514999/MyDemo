package com.drumbeatsoft.model;

import com.drumbeatsoft.utils.DateFormatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;
@Api(value="hit_prize模型",description = "中奖信息模型")
public class HitPrize implements Serializable {
    @ApiParam(value = "中奖id",hidden = true)
    private String id;                  //中奖信息id
    @ApiParam(value = "奖品id")
    private String prizeId;             //奖品id
    @ApiParam(value = "活动id")
    private String activityId;          //活动id
    @ApiParam(value = "奖品名称")
    private String prizeName;           //奖品名称
    @ApiParam(value = "中奖账户id")
    private String accountId;           //中奖账户id
    @ApiParam(value = "发放状态，0未发送，1已发送",hidden = true)
    private int status;                 //发放状态，0未发送，1已发送（保留字段）
    @ApiParam(value = "创建时间",hidden = true)
    private Date createDate;            //创建时间
    @ApiParam(value = "创建时间字符串",hidden = true)
    private String createDateStr;       //创建时间字符串

    public String getCreateDateStr() {
        return DateFormatUtil.dateToString(createDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "HitPrize{" +
                "id='" + id + '\'' +
                ", prizeId='" + prizeId + '\'' +
                ", activityId='" + activityId + '\'' +
                ", prizeName='" + prizeName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }
}
