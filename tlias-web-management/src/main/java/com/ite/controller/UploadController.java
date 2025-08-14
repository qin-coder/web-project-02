package com.ite.controller;

import com.ite.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String name, Integer age,
                         MultipartFile file) {
        log.info("接受参数: {},{},{}", name, age, file);
        return Result.success();
    }
}
