package com.ite.service;

import com.ite.pojo.Emp;
import com.ite.pojo.EmpQueryParam;
import com.ite.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface EmpService {
    /*分页查询*/
    PageResult<Emp> page(EmpQueryParam empQueryParam);
}
