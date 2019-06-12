package com.PO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 23:43
 * @Version 1.0
 * @Note
 */
@ApiModel("专业")
public class MajorPO {

    @ApiModelProperty("专业id")
    private Long id;

    @ApiModelProperty("专业编号")
    private String majorNum;

    @ApiModelProperty("专业名称")
    private String majorName;

    @ApiModelProperty("专业描述")
    private String briefDesc;

    private Date createTime;
    @ApiModelProperty("操作人")
    private String created;

    private Date updateTime;

    private String updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMajorNum() {
        return majorNum;
    }

    public void setMajorNum(String majorNum) {
        this.majorNum = majorNum == null ? null : majorNum.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc == null ? null : briefDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated == null ? null : updated.trim();
    }
}
