package com.dao;

import com.model.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

    List<Region> selectRegionList();
}