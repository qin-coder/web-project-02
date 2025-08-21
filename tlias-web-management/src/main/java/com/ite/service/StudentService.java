package com.ite.service;


import com.ite.pojo.PageResult;
import com.ite.pojo.Student;
import com.ite.pojo.StudentQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService  {
    /*分页查询*/
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void delete(List<Integer> ids);

    void add(Student student);

    Student getInfo(Integer id);

    void update(Student student);
}
