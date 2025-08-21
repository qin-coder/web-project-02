package com.ite.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ite.mapper.StudentMapper;
import com.ite.pojo.PageResult;
import com.ite.pojo.Student;
import com.ite.pojo.StudentQueryParam;
import com.ite.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(),
                studentQueryParam.getPageSize());
        //2.执行查询
        List<Student> empList = studentMapper.list(studentQueryParam);
        //3.解析查询结果并封装
        Page<Student> p = (Page<Student>) empList;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }
}
