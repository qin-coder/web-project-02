package com.ite.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.ite.pojo.Class;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ClassMapper {
    @Select("select * from class;")
    List<Class> findAll();

    List<Class> list(String name, LocalDate begin, LocalDate end);
}
