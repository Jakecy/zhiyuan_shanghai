package com.dao;

import com.model.University;

import java.util.List;

public interface UniversityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);

    List<University> selectUniversityList();
}