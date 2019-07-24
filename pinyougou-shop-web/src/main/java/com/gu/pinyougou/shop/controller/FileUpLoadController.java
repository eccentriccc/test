package com.gu.pinyougou.shop.controller;

import com.gu.pinyougou.utils.FileUploadUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileUpLoadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        String s = FileUploadUtils.fileUpload(file);
        System.out.println(s);
        return s;
    }
}
