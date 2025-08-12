package com.ite.controller;

import com.ite.pojo.Emp;
import com.ite.pojo.EmpQueryParam;
import com.ite.pojo.PageResult;
import com.ite.pojo.Result;
import com.ite.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/emps")

public class EmpController {
    @Autowired
    private EmpService empService;

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
}
