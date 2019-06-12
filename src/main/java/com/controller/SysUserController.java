package com.controller;

import com.PO.SysUserPO;
import com.result.Result;
import com.service.SysUserService;
import com.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 23:04
 * @Version 1.0
 * @Note
 */

@Api(value = "sysUserApi")
@CrossOrigin
@RestController
@RequestMapping("/sysUser")
public class SysUserController {


    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "保存", httpMethod = "POST", notes = "保存")
    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result<Boolean> add(@RequestBody SysUserPO sysUserPO) {
        return sysUserService.add(sysUserPO);
    }

    @ApiOperation(value = "删除", httpMethod = "GET", notes = "删除")
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public Result<Boolean> remove(@RequestParam Long id) {
        return sysUserService.remove(id);
    }



    @ApiOperation(value = "修改", httpMethod = "POST", notes = "修改")
    @RequestMapping(value = "/edit", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result<Boolean> edit(@RequestBody SysUserPO sysUserPO) {
        return sysUserService.edit(sysUserPO);
    }


    @ApiOperation(value = "查询账号详情", httpMethod = "GET", notes = "查询账号详情")
    @RequestMapping(value = "/getSysUserInfo", method = RequestMethod.GET)
    public Result<SysUserVO> getSysUserInfo(@RequestParam Long id) {
        return sysUserService.getSysUserInfo(id);
    }


    /**
     * 获取系统用户列表
     *
     */
    @ApiOperation(value = "获取系统用户列表", httpMethod = "GET", notes = "获取系统用户列表")
    @RequestMapping(value = "/getSysUserList", method = RequestMethod.GET)
    public Result<List<SysUserVO>> getSysUserList() {
        return new Result<List<SysUserVO>>().ok(sysUserService.getSysUserList());
    }

}
