package com.ite.service;

import java.time.LocalDate;
import java.util.List;
import com.ite.pojo.Class;
import com.ite.pojo.PageResult;

public interface ClassService {

    List<Class> findAll();

    PageResult page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    Class findById(Integer id);

    void deleteById(Integer id);

    void add(Class clazz);

    void update(Class clazz);
}
