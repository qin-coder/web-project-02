package com.ite.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ite.mapper.EmpExprMapper;
import com.ite.mapper.EmpMapper;
import com.ite.pojo.*;
import com.ite.service.EmpLogService;
import com.ite.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;



    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //1.设置分页参数
        PageHelper.startPage(empQueryParam.getPage(),
                empQueryParam.getPageSize());
        //2.执行查询
        List<Emp> empList = empMapper.list(empQueryParam);
        //3.解析查询结果并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());

    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void add(Emp emp) {
        try {
            //1.保存员工基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);
            //2.保存员工工作经历信息
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(expr -> {
                    expr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //记录操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(),
                    "新增员工:" + emp);
            empLogService.insertLog(empLog);

        }


    }
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        //1.批量删除员工信息
        empMapper.deleteByIds(ids);
        //2.批量删除员工工作经历信息
        empExprMapper.deleteByEmpIds(ids);

    }
}
