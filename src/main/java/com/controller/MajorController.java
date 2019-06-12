package com.controller;

import com.PO.MajorPO;
import com.result.Result;
import com.service.MajorService;
import com.vo.MajorVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 23:36
 * @Version 1.0
 * @Note
 */

@Api(value="majorApi",tags={"ZhuanYe"})
@CrossOrigin
@RestController
@RequestMapping("/major")
public class MajorController {


    @Autowired
    private MajorService majorService;


    @ApiOperation(value = "添加专业", httpMethod = "POST", notes = "添加专业")
    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result<Boolean> add(@RequestBody MajorPO majorPO) {
        return new  Result<Boolean>().ok( majorService.add(majorPO));
    }

    @ApiOperation(value = "删除专业", httpMethod = "GET", notes = "删除专业")
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public Result<Boolean> remove(@RequestParam Long id) {
        return new  Result<Boolean>().ok(majorService.remove(id)) ;
    }



    @ApiOperation(value = "修改专业", httpMethod = "POST", notes = "修改专业")
    @RequestMapping(value = "/edit", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result<Boolean> edit(@RequestBody MajorPO majorPO) {
        return new  Result<Boolean>().ok(majorService.edit(majorPO)) ;
    }


    @ApiOperation(value = "查询专业详情", httpMethod = "GET", notes = "查询专业详情")
    @RequestMapping(value = "/getMajorInfo", method = RequestMethod.GET)
    public Result<MajorVO> getMajorInfo(@RequestParam Long id) {
        return new  Result<MajorVO>().ok(majorService.getMajorInfo(id)) ;
    }

    /**
     * 获取系统用户列表
     *
     */
    @ApiOperation(value = "获取专业列表", httpMethod = "GET", notes = "获取专业列表")
    @RequestMapping(value = "/getMajorList", method = RequestMethod.GET)
    public Result<List<MajorVO>> getMajorList() {
        return new Result<List<MajorVO>>().ok(majorService.getMajorList());
    }



}
