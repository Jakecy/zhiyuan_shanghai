package com.service;

import com.dao.RegionMapper;
import com.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 22:22
 * @Version 1.0
 * @Note
 */
@Service
public class RegionService {


    @Autowired
    private RegionMapper regionMapper;


    public List<Region> getRegionList() {
        List<Region> regionList= regionMapper.selectRegionList();
        return  regionList;
    }
}
