package com.controller;

import com.PO.EnrollmentRecordPO;
import com.PO.SearchCondition;
import com.result.Result;
import com.service.UniversityEnrollmentRecordService;
import com.vo.EnrollmentRecordVO;
import com.vo.EnrollmentSearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: chihaojie
 * @Date: 2019/6/5 23:16
 * @Version 1.0
 * @Note
 */


@Api(value="enrollmentApi",tags={"Enrollment"})
@CrossOrigin
@RestController
@RequestMapping("/enrollment")
public class UniversityEnrollmentRecordController {


    @Autowired
    private UniversityEnrollmentRecordService universityEnrollmentRecordService;


    @ApiOperation(value = "新增填报志愿", httpMethod = "POST", notes = "新增填报志愿")
    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result<Boolean> save(@RequestBody EnrollmentRecordPO enrollmentRecordPO) {
        return new Result<Boolean>().ok(universityEnrollmentRecordService.save(enrollmentRecordPO));
    }

    @ApiOperation(value = "修改填报志愿", httpMethod = "POST", notes = "修改填报志愿")
    @RequestMapping(value = "/edit", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Result<Boolean> edit(@RequestBody EnrollmentRecordPO enrollmentRecordPO) {
        return new Result<Boolean>().ok(universityEnrollmentRecordService.edit(enrollmentRecordPO));
    }


    @ApiOperation(value = "remove填报志愿", httpMethod = "GET", notes = "删除填报志愿")
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public Result<Boolean> remove(@RequestParam("id") Long  id) {
        return new Result<Boolean>().ok(universityEnrollmentRecordService.remove(id));
    }


    /**
     * 获取高校列表
     *
     */
    @ApiOperation(value = "列表", httpMethod = "GET", notes = "列表")
    @RequestMapping(value = "/getEnrollmentRecordList", method = RequestMethod.GET)
    public Result<List<EnrollmentRecordVO>> getEnrollmentRecordList() {
        return new Result<List<EnrollmentRecordVO>>().ok(universityEnrollmentRecordService.getEnrollmentRecordList());
    }

    /**
     * getUniversityDetail
     */
    @ApiOperation(value = "列表", httpMethod = "GET", notes = "列表")
    @RequestMapping(value = "/getEnrollmentDetail", method = RequestMethod.GET)
    public Result<EnrollmentRecordVO> getEnrollmentDetail(@RequestParam("id") Long  id) {
        return new Result<EnrollmentRecordVO>().ok(universityEnrollmentRecordService.getEnrollmentDetail(id));
    }


    /**
     * 往年录取情况查询
     */
    @ApiOperation(value = "往年录取情况查询", httpMethod = "GET", notes = "往年录取情况查询")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Result<List<EnrollmentSearchVO>> search(@RequestParam(value = "studentRegion",required = true) String studentRegion ,@RequestParam(value = "type",required = true) String type  ,@RequestParam(value = "year",required = true) String year,

                                                   @RequestParam(value = "majorId",required = false) String majorId  ,@RequestParam(value = "universityId",required = false) String universityId) {
        //参数合法性校验
        SearchCondition condition =new SearchCondition();
        try{
            if(!StringUtils.isEmpty(majorId)){
                condition.setMajorId(Long.valueOf(majorId));
            }
            condition.setStudentRegion(Long.valueOf(studentRegion));
            condition.setType(Integer.valueOf(type));
            condition.setYear(Integer.valueOf(year));
            if(!StringUtils.isEmpty(universityId)){
                condition.setUniversityId(Long.valueOf(universityId));
            }
        }catch (Exception e){
           e.printStackTrace();
            return new Result<>().error("参数不合法！！！");
        }
        if(ObjectUtils.isEmpty(condition)){
            return new Result<>().error("参数缺失！！！");
        }
        if(ObjectUtils.isEmpty(condition.getStudentRegion()) || ObjectUtils.isEmpty(condition.getType())
                || ObjectUtils.isEmpty(condition.getYear())){
            return new Result<>().error("参数不完整！！！");
        }
        return new Result<List<EnrollmentSearchVO>>().ok(universityEnrollmentRecordService.search(condition));
    }

}
