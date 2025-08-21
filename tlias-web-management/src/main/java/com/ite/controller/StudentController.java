package com.ite.controller;


import com.ite.pojo.PageResult;
import com.ite.pojo.Result;
import com.ite.pojo.Student;
import com.ite.pojo.StudentQueryParam;
import com.ite.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
