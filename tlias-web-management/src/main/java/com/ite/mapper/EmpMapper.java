package com.ite.mapper;

import com.ite.pojo.Emp;
import com.ite.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    /*
     * 查询总记录数*/
    public List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, " +
            "salary, image, entry_date, dept_id, create_time, " +
            "update_time)" +
            "values (#{username},#{name},#{gender},#{phone},#{job}," +
            "#{salary},#{image},#{entryDate},#{deptId}," +
            "#{createTime},#{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    List<Map> countEmpGenderData();
}
