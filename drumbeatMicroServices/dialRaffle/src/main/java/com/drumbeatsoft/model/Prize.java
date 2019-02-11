package com.drumbeatsoft.model;

import com.drumbeatsoft.utils.DateFormatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;
@Api(value="prize模型",description = "奖品信息模型")
public class Prize implements Serializable {
    @ApiParam(value = "奖品id",hidden = true)
    private String prizeId;         //奖品id
    @ApiParam(value = "所属活动id",hidden = true)
    private String activityId;      //所属活动id
    @ApiParam(value = "是否有奖品(不可重复抽奖中，抽中为true后将无法再次抽中为true的)",required = true)
    private boolean something;            //是否有奖品
    @ApiParam(value = "奖品名称",required = true)
    private String name;            //奖品名称
    @ApiParam(value = "奖品个数",required = true)
    private int counts;             //奖品个数
    @ApiParam(value = "奖品等级",hidden = true)
    private int level;              //奖品等级(保留字段)
    @ApiParam(value = "中奖权重(抽中概率为权重比率，抽完后不再参与权重计算)",required = true)
    private int weight;       //中奖权重
    @ApiParam(value = "创建时间",hidden = true)
    private Date createDate;        //创建时间
    @ApiParam(value = "创建时间字符串",hidden = true)
    private String createDateStr;        //创建时间字符串
    @ApiParam(value = "创建人id",hidden = true)
    private String createUserId;    //创建人id
    @ApiParam(value = "创建人名称",hidden = true)
    private String createUserName;  //创建人名称
    @ApiParam(value = "更新时间",hidden = true)
    private Date modifyDate;        //更新时间
    @ApiParam(value = "更新时间字符串",hidden = true)
    private String modifyDateStr;        //更新时间字符串
    @ApiParam(value = "更新人id",hidden = true)
    private String modifyUserId;    //更新人id
    @ApiParam(value = "更新人名称",hidden = true)
    private String modifyUserName;  //更新人名称
    @ApiParam(value = "所属公司id",hidden = true)
    private String companyId;       //所属公司id
    @ApiParam(value = "是否有奖品字符串",hidden = true)
    private String somethingStr;    //是否有奖品字符串

    public String getCreateDateStr() {
        return DateFormatUtil.dateToString(createDate);
    }

    public String getModifyDateStr() {
        return DateFormatUtil.dateToString(modifyDate);
    }

    public String getSomethingStr() {
        if (something){
            return "有";
        }
        return "没有";
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

    public boolean isSomething() {
        return something;
    }

    public void setSomething(boolean something) {
        this.something = something;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "prizeId='" + prizeId + '\'' +
                ", activityId='" + activityId + '\'' +
                ", something=" + something +
                ", name='" + name + '\'' +
                ", counts=" + counts +
                ", level=" + level +
                ", weight=" + weight +
                ", createDate=" + createDate +
                ", createUserId='" + createUserId + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", modifyDate=" + modifyDate +
                ", modifyUserId='" + modifyUserId + '\'' +
                ", modifyUserName='" + modifyUserName + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
