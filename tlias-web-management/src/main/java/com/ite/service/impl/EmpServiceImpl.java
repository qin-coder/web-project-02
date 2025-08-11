package com.ite.service.impl;

import com.ite.mapper.EmpMapper;
import com.ite.pojo.Emp;
import com.ite.pojo.PageResult;
import com.ite.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1.调用mapper接口，查询总记录数
        long total = empMapper.count();
        //2.调用mapper接口，查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);
        //3.组装PageResult
        return new PageResult<Emp>(total, rows);

    }
}
