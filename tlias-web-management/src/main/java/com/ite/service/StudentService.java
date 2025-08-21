package com.ite.service;


import com.ite.pojo.PageResult;
import com.ite.pojo.Student;
import com.ite.pojo.StudentQueryParam;
import org.springframework.stereotype.Service;

@Service
public interface StudentService  {
    /*分页查询*/
    PageResult<Student> page(StudentQueryParam studentQueryParam);
}
