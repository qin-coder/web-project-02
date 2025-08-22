package com.ite.controller;

import com.ite.pojo.Emp;
import com.ite.pojo.LoginInfo;
import com.ite.pojo.Result;
import com.ite.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    private final EmpService empService;

    public LoginController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录:{}", emp);
        LoginInfo info = empService.login(emp);
        if(info != null){
            return Result.success(info);
        }
        return Result.error("用户名或密码错误");
    }
}
