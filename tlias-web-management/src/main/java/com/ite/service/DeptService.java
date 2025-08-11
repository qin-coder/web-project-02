package com.ite.service;

import com.ite.pojo.Dept;

import java.util.List;
//补全基础属性，调用mapper接口方法
public interface DeptService  {
    List<Dept> findAll();
    /*根据id删除部门*/
    void deleteById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void updateDept(Dept dept);
}
