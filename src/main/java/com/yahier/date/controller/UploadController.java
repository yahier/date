package com.yahier.date.controller;

import java.io.File;
import java.io.IOException;

import com.yahier.date.pojo.BaseResp;
import com.yahier.date.pojo.Fail;
import com.yahier.date.pojo.Success;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
@Controller
public class UploadController {
    //图片上传后 保存的路径
    private final String imgDir = "/Users/yahier/Desktop/";


    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public @ResponseBody
    BaseResp uploadImg(MultipartFile file) {//1
        System.out.println("UploadController 上传文件");
        String filePath = imgDir + file.getOriginalFilename();
        try {
            FileUtils.writeByteArrayToFile(new File(filePath), file.getBytes()); //2
            return new Success(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return new Fail("io异常");
        }


    }

}
