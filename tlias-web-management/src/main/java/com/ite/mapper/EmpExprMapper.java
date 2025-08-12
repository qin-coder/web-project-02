package com.ite.mapper;

import com.ite.pojo.EmpExpr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /*批量保存员工工作经历信息*/

    void insertBatch(List<EmpExpr> exprList);
}
