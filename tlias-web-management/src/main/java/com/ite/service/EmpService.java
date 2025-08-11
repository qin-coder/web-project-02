package com.ite.service;

import com.ite.pojo.Emp;
import com.ite.pojo.PageResult;
import org.springframework.stereotype.Service;

@Service
public interface EmpService {
    /*分页查询*/
    PageResult<Emp> page(Integer page, Integer pageSize);
}
