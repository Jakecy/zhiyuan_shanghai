package com.dao;

import com.model.UniversityEnrollmentRecord;
import com.vo.EnrollmentSearchVO;
import com.vo.ScoreDistributionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UniversityEnrollmentRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UniversityEnrollmentRecord record);

    int insertSelective(UniversityEnrollmentRecord record);

    UniversityEnrollmentRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UniversityEnrollmentRecord record);

    int updateByPrimaryKey(UniversityEnrollmentRecord record);

    List<UniversityEnrollmentRecord> selectEnrollmentRecordList();

    List<UniversityEnrollmentRecord> selectByCondition(UniversityEnrollmentRecord condition);

    ScoreDistributionVO selectScoreByStudentRegionAndUniversityIdAndTypeAndYear(@Param("studentRegion") Long studentRegion, @Param("universityId") Long universityId, @Param("type") Integer type, @Param("year") Integer year);

    List<EnrollmentSearchVO> selectUniversityEnrollmentInYear(UniversityEnrollmentRecord condition);

    ScoreDistributionVO selectScoreByStudentRegionAndUniversityIdAndTypeAndYear(UniversityEnrollmentRecord condition);
}