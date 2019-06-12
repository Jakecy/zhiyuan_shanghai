package com.PO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 22:45
 * @Version 1.0
 * @Note
 */
@ApiModel("高校")
public class UniversityPO {

    @ApiModelProperty("高校id")
    private Long id;
    @ApiModelProperty("高校编号")
    private String universityNum;
    @ApiModelProperty("高校名称")
    private String universityName;
    @ApiModelProperty("高校类型：1:985,2:211，3：普通高校")
    private Integer type;
    @ApiModelProperty("高校地区id")
    private Long regionId;
    @ApiModelProperty("高校详细地址")
    private String detailAddress;
    @ApiModelProperty("高校招生热线")
    private String hotline;
    @ApiModelProperty("高校id")
    private String gatePhoto;
    @ApiModelProperty("高校简介")
    private String briefDesc;
    @ApiModelProperty("高校人数规模")
    private Integer scale;

    private Date createTime;

    private String created;

    private Date updateTime;

    private String updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityNum() {
        return universityNum;
    }

    public void setUniversityNum(String universityNum) {
        this.universityNum = universityNum == null ? null : universityNum.trim();
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName == null ? null : universityName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline == null ? null : hotline.trim();
    }

    public String getGatePhoto() {
        return gatePhoto;
    }

    public void setGatePhoto(String gatePhoto) {
        this.gatePhoto = gatePhoto == null ? null : gatePhoto.trim();
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc == null ? null : briefDesc.trim();
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
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
