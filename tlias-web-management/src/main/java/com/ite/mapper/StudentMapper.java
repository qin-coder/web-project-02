package com.ite.mapper;

import com.ite.pojo.Student;
import com.ite.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    public List<Student> list(StudentQueryParam studentQueryParam);


}