package com.ite.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Select("select id,name,room,create_time,update_time from class" +
            " where id = ${id}")
    Class findById(Integer id);

    /*根据id删除班级*/
    @Delete("delete from class where id = ${id}")
    void deleteById(Integer id);

    @Insert("insert into class(name,room,begin_date,end_date,master_id,subject) " +
            "values(#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject})")
    void add(Class clazz);
}
