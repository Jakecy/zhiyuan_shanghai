package com.service;

import com.PO.MajorPO;
import com.dao.MajorMapper;
import com.model.Major;
import com.vo.MajorVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.testng.collections.Lists;

import java.util.Date;
import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 23:38
 * @Version 1.0
 * @Note
 */

@Service
public class MajorService {

    @Autowired
    private MajorMapper majorMapper;


    public Boolean add(MajorPO majorPO) {
        Major major =new Major();
        BeanUtils.copyProperties(majorPO,major);
        Date time = new Date();
        major.setCreateTime(time);
        major.setUpdateTime(time);
        majorMapper.insert(major);
        return  true;
    }

    public Boolean remove(Long id) {
        majorMapper.deleteByPrimaryKey(id);
        return true;
    }

    public Boolean edit(MajorPO majorPO) {
        Major major = majorMapper.selectByPrimaryKey(majorPO.getId());
        if(!ObjectUtils.isEmpty(major)){
            throw new RuntimeException("该记录不存在");
        }
        BeanUtils.copyProperties(majorPO,major);
        Date time = new Date();
        major.setCreateTime(time);
        major.setUpdateTime(time);
        majorMapper.updateByPrimaryKey(major);
        return true;
    }

    public MajorVO getMajorInfo(Long id) {
        MajorVO vo=new MajorVO();
        Major major = majorMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(major,vo);
        return vo;
    }


    public List<MajorVO> getMajorList() {
        List<MajorVO> voList= Lists.newArrayList();
        List<Major> list=  majorMapper.selectMajorList();
        if(!ObjectUtils.isEmpty(list)){
            for (Major u: list) {
                MajorVO vo=new MajorVO();
                BeanUtils.copyProperties(u,vo);
                voList.add(vo);
            }
        }
        return voList;
    }
}
