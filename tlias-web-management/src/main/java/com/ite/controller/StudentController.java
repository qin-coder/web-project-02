package com.ite.controller;


import com.ite.pojo.PageResult;
import com.ite.pojo.Result;
import com.ite.pojo.Student;
import com.ite.pojo.StudentQueryParam;
import com.ite.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("分页查询 : {}", studentQueryParam);
        PageResult<Student> pageResult =
                studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }
    /*删除学员*/
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除：{}", ids);
        studentService.delete(ids);
        return Result.success();
    }
    /*添加学员*/
    @PostMapping
    public Result add(@RequestBody Student student) {
        log.info("添加学员:{}", student);
        studentService.add(student);
        return Result.success();
    }
    /* 根据ID查询*/
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("查询ID为{}的学员", id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }
    /* 修改学员*/
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学员:{}", student);
        studentService.update(student);
        return Result.success();
    }
}
