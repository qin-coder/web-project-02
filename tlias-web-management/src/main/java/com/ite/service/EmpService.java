package com.ite.service;

import com.ite.pojo.Emp;
import com.ite.pojo.EmpQueryParam;
import com.ite.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {
    /*分页查询*/
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void add(Emp emp);

    void delete(List<Integer> ids);
}
