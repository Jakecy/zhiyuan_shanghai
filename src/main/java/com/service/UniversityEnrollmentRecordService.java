package com.service;

import com.PO.EnrollmentRecordPO;
import com.PO.SearchCondition;
import com.dao.RegionMapper;
import com.dao.UniversityEnrollmentRecordMapper;
import com.dao.UniversityMapper;
import com.model.Region;
import com.model.University;
import com.model.UniversityEnrollmentRecord;
import com.vo.EnrollmentRecordVO;
import com.vo.EnrollmentSearchVO;
import com.vo.ScoreDistributionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.testng.collections.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 23:19
 * @Version 1.0
 * @Note
 */

@Service
public class UniversityEnrollmentRecordService {

    @Autowired
    private UniversityEnrollmentRecordMapper  enrollmentRecordMapper;

    @Autowired
    private UniversityMapper universityMapper;

    @Autowired
    private RegionMapper regionMapper;


    public Boolean save(EnrollmentRecordPO enrollmentRecordPO) {
        UniversityEnrollmentRecord  record=new UniversityEnrollmentRecord();
        BeanUtils.copyProperties(enrollmentRecordPO,record);
        Date time = new Date();
        record.setCreateTime(time);
        record.setCreated(enrollmentRecordPO.getCreated());
        record.setUpdateTime(time);
        record.setUpdated(enrollmentRecordPO.getUpdated());
        enrollmentRecordMapper.insert(record);
        return true;
    }

    public Boolean edit(EnrollmentRecordPO enrollmentRecordPO) {
        UniversityEnrollmentRecord university = enrollmentRecordMapper.selectByPrimaryKey(enrollmentRecordPO.getId());
        if(ObjectUtils.isEmpty(university)){
            throw new RuntimeException("该记录不存在");
        }
        BeanUtils.copyProperties(enrollmentRecordPO,university);
        Date time = new Date();
        university.setCreateTime(time);
        university.setCreated(enrollmentRecordPO.getCreated());
        university.setUpdateTime(time);
        university.setUpdated(enrollmentRecordPO.getUpdated());
        enrollmentRecordMapper.updateByPrimaryKey(university);
        return true;
    }

    public Boolean remove(Long id) {
        enrollmentRecordMapper.deleteByPrimaryKey(id);
        return true;
    }

    public List<EnrollmentRecordVO> getEnrollmentRecordList() {
        List<EnrollmentRecordVO> voList= Lists.newArrayList();
        List<UniversityEnrollmentRecord> list=  enrollmentRecordMapper.selectEnrollmentRecordList();
        if(!ObjectUtils.isEmpty(list)){
            for (UniversityEnrollmentRecord  u: list) {
                Region region = regionMapper.selectByPrimaryKey(u.getStudentRegion());
                EnrollmentRecordVO vo=new EnrollmentRecordVO();
                BeanUtils.copyProperties(u,vo);
                if(!ObjectUtils.isEmpty(region)){
                    vo.setStudentRegionName(region.getName());
                }
                voList.add(vo);
            }
        }
        return voList;
    }

    public List<EnrollmentSearchVO> search(SearchCondition conditionPO) {
        List<EnrollmentSearchVO>  list=Lists.newArrayList();
        UniversityEnrollmentRecord  condition=new UniversityEnrollmentRecord();
        BeanUtils.copyProperties(conditionPO,condition);
        //查询某个学校，某一年在某个地区文理科的学校信息
        List<EnrollmentSearchVO>  searchVOList=  enrollmentRecordMapper.selectUniversityEnrollmentInYear(condition);
        if(!ObjectUtils.isEmpty(searchVOList)){
            //计算 录取的最高分 最低分 平均分
            for (EnrollmentSearchVO  record: searchVOList) {
                //查询每个学校的最高分、最低分、平均分
                condition.setUniversityId(record.getUniversityId());
                condition.setType(conditionPO.getType().byteValue());
                ScoreDistributionVO scoreDistributionVO=   enrollmentRecordMapper.selectScoreByStudentRegionAndUniversityIdAndTypeAndYear(condition);
                University university = universityMapper.selectByPrimaryKey(record.getUniversityId());
                if(!ObjectUtils.isEmpty(university)){
                    record.setUniversityType(university.getType().intValue());
                    record.setGatePhoto(university.getGatePhoto());
                    record.setBriefDesc(university.getBriefDesc());
                }
                record.setYear(condition.getYear());
                record.setMaxScore(scoreDistributionVO.getMaxScore());
                record.setAvgScore(scoreDistributionVO.getAvgScore());
                record.setMinScore(scoreDistributionVO.getMinScore());
                list.add(record);
            }
            //按照录取分数排序
            Collections.sort(list, Comparator.comparing(EnrollmentSearchVO::getAvgScore));
        }
        return  list;
    }

    public EnrollmentRecordVO getEnrollmentDetail(Long id) {
        EnrollmentRecordVO  vo=new EnrollmentRecordVO();
        UniversityEnrollmentRecord enrollmentRecord = enrollmentRecordMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(enrollmentRecord)){
            throw new RuntimeException("该记录不存在");
        }
        BeanUtils.copyProperties(enrollmentRecord,vo);
        return vo;
    }
}
