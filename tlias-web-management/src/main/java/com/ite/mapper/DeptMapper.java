package com.ite.mapper;

import com.ite.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

//通过注解定义 SQL 操作，实现部门数据的操作
@Mapper
public interface DeptMapper {
    /*查询所有部门数据*/
    //方式1：手动结果映射
//    @Results({
//            @Result(column = "create_time", property =
//            "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
    //方式2：起别名

    @Select("select id, name, create_time , update_time from dept " +
            "order by update_time desc")
    List<Dept> findAll();

    /*根据id删除部门*/
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) " +
            "values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    /*添加部门*/
}
