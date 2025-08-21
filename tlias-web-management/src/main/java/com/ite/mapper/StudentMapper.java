package com.ite.mapper;

import com.ite.pojo.Student;
import com.ite.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    @Select("SELECT\n" +
            "    name,\n" +
            "    no,\n" +
            "    gender,\n" +
            "    phone,\n" +
            "    id_card,\n" +
            "    is_college,\n" +
            "    address,\n" +
            "    degree,\n" +
            "    graduation_date,\n" +
            "    clazz_id,\n" +
            "    create_time,\n" +
            "    update_time\n" +
            "FROM student\n" +
            "WHERE id = #{id};")
    Student getInfo(Integer id);

    @Update("UPDATE student\n" +
            "SET\n" +
            "    name = #{name},\n" +
            "    no = #{no},\n" +
            "    gender = #{gender},\n" +
            "    phone = #{phone},\n" +
            "    id_card = #{idCard},\n" +
            "    is_college = #{isCollege},\n" +
            "    address = #{address},\n" +
            "    degree = #{degree},\n" +
            "    graduation_date = #{graduationDate},\n" +
            "    clazz_id = #{clazzId},\n" +
            "    update_time = #{updateTime}\n" +
            "WHERE id = #{id};")
    void updateById(Student student);

    @Update("UPDATE student SET " +
            "violation_count = IFNULL(violation_count, 0) + 1, " +
            "violation_score = IFNULL(violation_score, 0) + #{score}, " +
            "update_time = NOW() " +
            "WHERE id = #{id}")
    void handleViolation(@Param("id") Integer id, @Param("score") Integer score);
    @MapKey("pos")
    List<Map> countStudentDegreeData();
}