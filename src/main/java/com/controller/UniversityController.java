package com.controller;

import com.PO.UniversityPO;
import com.result.Result;
import com.service.UniversityService;
import com.vo.UniversityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 22:41
 * @Version 1.0
 * @Note
 */

@Api(value="UniversityApi",tags={"DaXue"})
@CrossOrigin
@RestController
@RequestMapping("/university")
public class UniversityController {


    @Autowired
    private UniversityService universityService;

    @ApiOperation(value = "新增资源", httpMethod = "POST", notes = "新增资源")
    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result<Boolean> save(@RequestBody UniversityPO universityPO) {
        return new Result<Boolean>().ok(universityService.save(universityPO));
    }

    @ApiOperation(value = "修改资源", httpMethod = "POST", notes = "修改")
    @RequestMapping(value = "/edit", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result<Boolean> edit(@RequestBody UniversityPO universityPO) {
        return new Result<Boolean>().ok(universityService.edit(universityPO));
    }

    @ApiOperation(value = "查询详情", httpMethod = "GET", notes = "查询详情")
    @RequestMapping(value = "/getUniversityDetail", method = RequestMethod.GET)
    public Result<UniversityVO> getUniversityDetail(@RequestParam("id") Long  id) {
        return new Result<UniversityVO>().ok(universityService.getUniversityDetail(id));
    }

    @ApiOperation(value = "remove", httpMethod = "GET", notes = "删除资源")
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public Result<Boolean> remove(@RequestParam("id") Long  id) {
        return new Result<Boolean>().ok(universityService.remove(id));
    }



    /**
     * 获取高校列表
     *
     */
    @ApiOperation(value = "获取高校列表", httpMethod = "GET", notes = "获取高校列表")
    @RequestMapping(value = "/getUnivertyList", method = RequestMethod.GET)
    public Result<List<UniversityVO>> getUnivertyList() {
        return new Result<List<UniversityVO>>().ok(universityService.getUnivertyList());
    }

}
