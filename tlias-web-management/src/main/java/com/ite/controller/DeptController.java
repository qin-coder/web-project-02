package com.ite.controller;

import com.ite.pojo.Dept;
import com.ite.pojo.Result;
import com.ite.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//调用service层，响应结果
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    //查询所有部门数据
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    //删除部门数据
    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest  request) {
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("删除部门数据" +  id);
//        return Result.success();
//
//    }
    public Result delete( Integer id) {
        System.out.println("删除部门数据" +  id);
        deptService.deleteById(id);
        return Result.success();

    }
    /*添加部门*/
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        System.out.println("添加部门数据" +  dept);
        deptService.add(dept);
        return Result.success();
    }

}
