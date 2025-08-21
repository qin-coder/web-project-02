package com.ite.mapper;

import com.ite.pojo.Student;
import com.ite.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    public List<Student> list(StudentQueryParam studentQueryParam);


    void deleteByIds(List<Integer> ids);

    @Insert("insert into student(name, no, gender, phone,id_card, " +
            "is_college, address, degree, graduation_date,clazz_id," +
            " create_time, update_time)\n" +
            "                    VALUES (#{name},#{no},#{gender}," +
            "#{phone},#{idCard},#{isCollege},#{address},#{degree}," +
            "#{graduationDate}, #{clazzId},#{createTime}," +
            "#{updateTime})")
    void insertBatch(Student student);
}