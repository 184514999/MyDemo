package com.drumbeatsoft.model;

import com.drumbeatsoft.utils.DateFormatUtil;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Api(value="activety模型",description = "活动信息模型")
public class Activity implements Serializable {

    @ApiParam(value = "活动id",hidden = true)
    private String activityId;   //活动id
    @ApiParam(value = "活动标题",required = true)
    private String title;          //活动标题
    @ApiParam(value = "活动开始时间",required = true)
    private Date startTime;         //活动开始时间
    @ApiParam(value = "活动开始时间字符串",required = true)
    private String startTimeStr;         //活动开始时间字符串
    @ApiParam(value = "活动结束时间",required = true)
    private Date endTime;           //活动结束时间
    @ApiParam(value = "活动结束时间字符串",required = true)
    private String endTimeStr;           //活动结束时间字符串
    @ApiParam(value = "可抽取的次数",hidden = true)
    private int times;              //可抽取的次数
    @ApiParam(value = "活动状态",hidden = true)
    private int status;             //活动状态 0未开始，1未开始不可更改，2已开始，3已结束
    @ApiParam(value = "活动状态字符串表示",hidden = true)
    private String statusStr;       //活动状态字符串表示
    @ApiParam(value = "创建人id",hidden = true)
    private String createUserId;        //创建人id
    @ApiParam(value = "创建人名称",hidden = true)
    private String createUserName;       //创建人名称
    @ApiParam(value = "发起活动公司id",hidden = true)
    private String companyId;       //发起活动公司id
    @ApiParam(value = "发起活动公司名称",hidden = true)
    private String companyName;     //发起活动公司名称
    @ApiParam(value = "活动创建时间",hidden = true)
    private Date createDate;        //活动创建时间
    @ApiParam(value = "活动创建时间字符串",hidden = true)
    private String createDateStr;        //活动创建时间字符串
    @ApiParam(value = "更新人id",hidden = true)
    private String modifyUserId;        //更新人id
    @ApiParam(value = "更新人名称",hidden = true)
    private String modifyUserName;      //更新人名称
    @ApiParam(value = "更新日期",hidden = true)
    private Date modifyDate;            //更新日期
    @ApiParam(value = "更新日期字符串",hidden = true)
    private String modifyDateStr;            //更新日期字符串
    @ApiParam(value = "是否可重复中奖")
    private boolean multiple;           //是否可重复中奖
    @ApiParam(value = "是否可重复中奖字符串表示")
    private String multipleStr;           //是否可重复中奖字符串表示
    @ApiParam(value = "活动所有奖品")
    private List<Prize> prizes;         //活动所有奖品

    public String getStartTimeStr() {
        return DateFormatUtil.dateToString(startTime);
    }

    public String getEndTimeStr() {
        return DateFormatUtil.dateToString(endTime);
    }

    public String getCreateDateStr() {
        return DateFormatUtil.dateToString(createDate);
    }

    public String getModifyDateStr() {
        return DateFormatUtil.dateToString(modifyDate);
    }

    public String getStatusStr() {
        int status = getStatus();
        if (status == 0){
            return "未开始";
        }else if (status == 1){
            return "准备开始";
        }else if (status == 2){
            return "已开始";
        }
        return "已结束";
    }

    public String getMultipleStr() {
        boolean multiple = isMultiple();
        if (multiple){
            return "可多次中奖";
        }
        return "不可多次中奖";
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public void setMultiple(boolean multiple) {
        this.multiple = multiple;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId='" + activityId + '\'' +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", times=" + times +
                ", status=" + status +
                ", createUserId='" + createUserId + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", createDate=" + createDate +
                ", modifyUserId='" + modifyUserId + '\'' +
                ", modifyUserName='" + modifyUserName + '\'' +
                ", modifyDate=" + modifyDate +
                ", multiple=" + multiple +
                ", prizes=" + prizes +
                '}';
    }
}
