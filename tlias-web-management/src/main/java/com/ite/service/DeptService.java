package com.ite.service;

import com.ite.pojo.Dept;

import java.util.List;

public interface DeptService  {
    List<Dept> findAll();
    /*根据id删除部门*/
    void deleteById(Integer id);
}
