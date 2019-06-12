package com.vo;

/**
 * @Author: chihaojie
 * @Date: 2019/6/6 0:05
 * @Version 1.0
 * @Note
 */
public class EnrollmentSearchVO {

    //学校id
    //学校简介
    //学校门头照
    //学校编码
    //学校类型
    //学校名称
    //年份
    //录取的最高分 最低分 平均分
    //学校简介
    private Long universityId;

    private String universityName;

    private Integer universityType;

    private String gatePhoto;

    private String briefDesc;

    private Integer year;

    private Double  maxScore;

    private Double  avgScore;

    private  Double  minScore;

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGatePhoto() {
        return gatePhoto;
    }

    public void setGatePhoto(String gatePhoto) {
        this.gatePhoto = gatePhoto;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public Integer getUniversityType() {
        return universityType;
    }

    public void setUniversityType(Integer universityType) {
        this.universityType = universityType;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public Double getMinScore() {
        return minScore;
    }

    public void setMinScore(Double minScore) {
        this.minScore = minScore;
    }

    @Override
    public String toString() {
        return "EnrollmentSearchVO{" +
                "universityId=" + universityId +
                ", universityName='" + universityName + '\'' +
                ", universityType=" + universityType +
                ", gatePhoto='" + gatePhoto + '\'' +
                ", briefDesc='" + briefDesc + '\'' +
                ", year=" + year +
                ", maxScore=" + maxScore +
                ", avgScore=" + avgScore +
                ", minScore=" + minScore +
                '}';
    }
}
