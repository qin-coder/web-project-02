package com.ite.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ite.mapper.ClassMapper;
import com.ite.pojo.PageResult;
import com.ite.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ite.pojo.Class;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    public List<Class> findAll() {
        return classMapper.findAll();
    }

    @Override
    public PageResult page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Class> dataList = classMapper.list(name,begin,end);
        Page<Class> p = (Page<Class>) dataList;

        return new PageResult(p.getTotal(), p.getResult());
    }

    @Override
    public Class findById(Integer id) {
        return classMapper.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        classMapper.deleteById(id);
    }
}
