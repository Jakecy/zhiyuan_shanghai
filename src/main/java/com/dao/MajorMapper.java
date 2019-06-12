package com.dao;

import com.model.Major;

import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    List<Major> selectMajorList();
}