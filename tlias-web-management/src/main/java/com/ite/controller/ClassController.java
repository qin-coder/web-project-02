package com.ite.controller;
import com.ite.pojo.PageResult;
import com.ite.pojo.Result;
import com.ite.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.ite.pojo.Class;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClassController {

    @Autowired
    private ClassService classService;
    //查询所有班级数据
    @GetMapping("/list")
    public Result list() {
        List<Class> classList = classService.findAll();
        return Result.success(classList);
    }

    /**
     * 条件分页查询班级
     */
    @GetMapping
    public Result page(String name ,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin ,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page ,
                       @RequestParam(defaultValue = "10")Integer pageSize){
        PageResult pageResult = classService.page(name , begin , end , page , pageSize);
        return Result.success(pageResult);
    }/*根据id查询班级*/
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Class clazz = classService.findById(id);
        return Result.success(clazz);
    }
    /*删除班级*/
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除班级:{}", id);
        classService.deleteById(id);
        return Result.success();
    }


}
