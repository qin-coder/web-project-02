package com.ite.controller;

import com.ite.pojo.Dept;
import com.ite.pojo.Result;
import com.ite.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)3
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
}
