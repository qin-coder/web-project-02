package com.ite.mapper;

import org.apache.ibatis.annotations.*;
import com.ite.pojo.Class;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    @Insert("insert into class(name,room,begin_date,end_date," +
            "master_id,subject) " +
            "values(#{name},#{room},#{beginDate},#{endDate}," +
            "#{masterId},#{subject})")
    void add(Class clazz);

    @Update("update class set name = #{name},room = #{room}," +
            "begin_date = #{beginDate},end_date = #{endDate}," +
            "master_id=#{masterId},subject=#{subject} where id = #{id}")
    void updateClass(Class clazz);
    /**
     * 统计每个班级的学生人数
     * 返回格式: [{"clazzName": "Java班", "studentCount": 25}, ...]
     */
    @Select("SELECT c.name as clazzName, COUNT(s.id) as studentCount " +
            "FROM class c " +
            "LEFT JOIN student s ON c.id = s.clazz_id " +
            "GROUP BY c.id, c.name " +
            "ORDER BY studentCount DESC " )
    List<Map<String, Object>> getClazzStudentCount();
}
