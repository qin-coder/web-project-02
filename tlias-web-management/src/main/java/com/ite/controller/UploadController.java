package com.ite.controller;

import com.ite.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String name, Integer age,
                         MultipartFile file) throws Exception {
        log.info("接受参数: {},{},{}", name, age, file);
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //新的文件名
        String extension =
                originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + extension;
        file.transferTo(new File("D:/projectFiles/" + newFileName));
        return Result.success();
    }
}
