package com.service;

import com.PO.UniversityPO;
import com.dao.UniversityMapper;
import com.model.University;
import com.vo.UniversityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.testng.collections.Lists;

import java.util.Date;
import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 22:44
 * @Version 1.0
 * @Note
 */

@Service
public class UniversityService {


    @Autowired
    private UniversityMapper   universityMapper;

    public  List<UniversityVO> getUnivertyList() {
        List<UniversityVO> voList= Lists.newArrayList();
        List<University> list=  universityMapper.selectUniversityList();
        if(!ObjectUtils.isEmpty(list)){
            for (University u: list) {
                UniversityVO vo=new UniversityVO();
                BeanUtils.copyProperties(u,vo);
                voList.add(vo);
            }
        }
        return voList;
    }


    public Boolean save(UniversityPO universityPO) {
        University   university =new University();
        BeanUtils.copyProperties(universityPO,university);
        Date time = new Date();
        university.setCreateTime(time);
        university.setUpdateTime(time);
        university.setUpdated(universityPO.getUpdated());
        universityMapper.insert(university);
        return  true;
    }

    public Boolean edit(UniversityPO universityPO) {
        University university = universityMapper.selectByPrimaryKey(universityPO.getId());
        if(ObjectUtils.isEmpty(university)){
            throw new RuntimeException("该记录不存在");
        }
        BeanUtils.copyProperties(universityPO,university);
        Date time = new Date();
        university.setUpdateTime(time);
        university.setUpdated(universityPO.getUpdated());
        universityMapper.updateByPrimaryKey(university);
        return true;
    }

    public Boolean remove(Long id) {
        universityMapper.deleteByPrimaryKey(id);
        return true;
    }

    public UniversityVO getUniversityDetail(Long id) {
        UniversityVO  vo=new UniversityVO();
        University university = universityMapper.selectByPrimaryKey(id);
        if(ObjectUtils.isEmpty(university)){
            throw new RuntimeException("该记录不存在");
        }
        BeanUtils.copyProperties(university,vo);
        return vo;
    }
}
