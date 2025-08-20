package com.ite.controller;

import com.ite.mapper.EmpExprMapper;
import com.ite.mapper.EmpMapper;
import com.ite.pojo.Emp;
import com.ite.pojo.EmpQueryParam;
import com.ite.pojo.PageResult;
import com.ite.pojo.Result;
import com.ite.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")

public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询 : {}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);

    }
    /*新增员工*/
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("新增员工:{}", emp);
        empService.add(emp);
        return Result.success();
    }
    /*删除员工*/
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根据id查询员工的详细信息");
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工:{}", emp);
        empService.update(emp);
        return Result.success();
    }

}
