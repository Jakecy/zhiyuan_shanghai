package com.service;

import com.PO.SysUserPO;
import com.dao.SysUserMapper;
import com.model.SysUser;
import com.result.Result;
import com.vo.SysUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.testng.collections.Lists;

import java.util.Date;
import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 23:05
 * @Version 1.0
 * @Note
 */

@Service
public class SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;


    public Result<Boolean> add(SysUserPO sysUserPO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserPO,sysUser);
        Date time = new Date();
        sysUser.setCreateTime(time);
        sysUser.setUpdateTime(time);
        sysUser.setUpdated(sysUser.getCreated());
        sysUser.setStatus(1);
        sysUserMapper.insert(sysUser);
        return new Result<Boolean>().ok(true);
    }

    public Result<Boolean> remove(Long id) {
        sysUserMapper.deleteByPrimaryKey(id);
        return new Result<Boolean>().ok(true);
    }

    public Result<Boolean> edit(SysUserPO sysUserPO) {
        //判断用户是否存在
        SysUser s = sysUserMapper.selectByPrimaryKey(sysUserPO.getId());
        if (s == null){
            return new Result<Boolean>().error("的用户不存在");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserPO,sysUser);

        Date time = new Date();
        sysUser.setUpdateTime(time);
        sysUser.setUpdated(sysUserPO.getUpdated());
        sysUserMapper.updateByPrimaryKey(sysUser);
        return new Result<Boolean>().ok(true);
    }

    public Result<SysUserVO> getSysUserInfo(Long id) {
        SysUserVO vo=new SysUserVO();
        SysUser user = sysUserMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(user,vo);
        return new Result<SysUserVO>().ok(vo);
    }

    public List<SysUserVO> getSysUserList() {
        List<SysUserVO> list= Lists.newArrayList();
        List<SysUser>  userList = sysUserMapper.selectSysUserList();
        if(!ObjectUtils.isEmpty(userList)){
            for (SysUser u: userList
                 ) {
                SysUserVO vo=new SysUserVO();
                BeanUtils.copyProperties(u,vo);
                list.add(vo);
            }
        }
        return list;
    }
}
