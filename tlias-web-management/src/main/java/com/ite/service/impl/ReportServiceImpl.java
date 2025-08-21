package com.ite.service.impl;

import com.ite.mapper.ClassMapper;
import com.ite.mapper.EmpMapper;
import com.ite.mapper.StudentMapper;
import com.ite.pojo.JobOption;
import com.ite.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassMapper classMapper;
        
    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }

    @Override
    public Map<String, Object> getClazzStudentCount() {
        List<Map<String, Object>> countList = classMapper.getClazzStudentCount();

        // 转换为要求的格式
        List<String> clazzList = new ArrayList<>();
        List<Integer> dataList = new ArrayList<>();

        for (Map<String, Object> map : countList) {
            clazzList.add((String) map.get("clazzName"));
            dataList.add(((Long) map.get("studentCount")).intValue()); // 注意COUNT返回的是Long类型
        }

        Map<String, Object> result = new HashMap<>();
        result.put("clazzList", clazzList);
        result.put("dataList", dataList);

        return result;
    }


}