package com.ite.mapper;

import com.ite.pojo.Emp;
import com.ite.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /*
     * 查询总记录数*/
    //原始分页查询方式
//    @Select("select count(*) from emp e left join dept d on " +
//            "dept_id = d.id;")
//    public long count();
//
//    @Select("select e.* , d.name deptName from emp e left join
//    dept" +
//            " d on " +
//            "e.dept_id = d.id order by e.update_time desc limit " +
//            "#{start},#{pageSize };")
//    public List<Emp> list(Integer start, Integer pageSize); ;

    //    @Select("select e.* , d.name deptName from emp e left
    //    join dept" +
//            " d on e.dept_id = d.id order by e.update_time desc")
    public List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, " +
            "salary, image, entry_date, dept_id, create_time, " +
            "update_time)" +
            "values (#{username},#{name},#{gender},#{phone},#{job}," +
            "#{salary},#{image},#{entryDate},#{deptId}," +
            "#{createTime},#{updateTime})")
    void insert(Emp emp);

    ;
}
