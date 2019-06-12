package com.dao;

import com.model.UniversityRelationMajor;

public interface UniversityRelationMajorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UniversityRelationMajor record);

    int insertSelective(UniversityRelationMajor record);

    UniversityRelationMajor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UniversityRelationMajor record);

    int updateByPrimaryKey(UniversityRelationMajor record);
}