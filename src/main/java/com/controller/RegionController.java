package com.controller;

import com.model.Region;
import com.result.Result;
import com.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 22:05
 * @Version 1.0
 * @Note
 */

@Api(value="regionApi",tags={"DiQu"})
@CrossOrigin
@RestController
@RequestMapping("/region")
public class RegionController {


    @Autowired
    private RegionService  regionService;

    @ApiOperation(value = "获取地区列表", httpMethod = "GET", notes = "获取地区列表")
    @RequestMapping(value = "/getRegionList", method = RequestMethod.GET)
    public Result<List<Region>> getRegionList() {
        return new Result<List<Region>>().ok(regionService.getRegionList());
    }

}
