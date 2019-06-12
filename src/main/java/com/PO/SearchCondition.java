package com.PO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: chihaojie
 * @Date: 2019/6/6 0:24
 * @Version 1.0
 * @Note
 */
@ApiModel("查询条件")
public class SearchCondition {


    //必选
    @ApiModelProperty("地区id")
    private Long  studentRegion;

    //必选
    @ApiModelProperty("高校id")
    private Long  universityId;

    //

    private Long  universityRegionId;

    @ApiModelProperty("专业id")
    private Long  majorId;

    //必选
    @ApiModelProperty("文理科：1：文科，2：理科")
    private Integer  type;

    //必选
    @ApiModelProperty("年份，传int的年份，如：2018")
    private Integer year;


    public Long getStudentRegion() {
        return studentRegion;
    }

    public void setStudentRegion(Long studentRegion) {
        this.studentRegion = studentRegion;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public Long getUniversityRegionId() {
        return universityRegionId;
    }

    public void setUniversityRegionId(Long universityRegionId) {
        this.universityRegionId = universityRegionId;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
