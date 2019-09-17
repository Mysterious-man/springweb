package com.acghome.controller;


import com.acghome.utils.ResourcePath;
import com.acghome.utils.Result;
import com.acghome.utils.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;


@Controller
@RequestMapping(value = "/")

public class FileController {



    @Autowired
    private com.acghome.service.IUserService IUserService;

    private final static Logger logger = LoggerFactory.getLogger(FileController.class);



    @ResponseBody
    @RequestMapping(value = "picture/upload")
    public Result saveUpload(@RequestParam("file") MultipartFile fileinput, HttpServletRequest request) {



        if (fileinput.isEmpty()) {
            return ResultGenerator.genFailResult("上传图片为null");
        }

        // 原始文件名
        String originalFileName = fileinput.getOriginalFilename();
        // 获取图片后缀
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
        String fileName = UUID.randomUUID().toString() + suffix;
        // 图片存储路径
        Path filePath = ResourcePath.getImgAbsPath(request).resolve(fileName);
        //图片的相对访问路径
        String url=ResourcePath.getImgPath().resolve(fileName).toString();

        try {

            Files.write(filePath, fileinput.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("上传图片失败");
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("url",url);
        map.put("img_abspath",filePath.toString());

        return ResultGenerator.genSuccessResult(map);

    }




    @ResponseBody
    @GetMapping("download")
    public Result downloadFile(HttpServletResponse response, HttpServletRequest request) {
        String fileName = "Spring.docx";
        Path filePath = ResourcePath.getfileAbsPath(request).resolve(fileName);

        File file = filePath.toFile();

        if (!file.exists()) {
            return ResultGenerator.genFailResult("该文件不存在不能下载");
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);

        byte[] buffer = new byte[1024];

        BufferedInputStream input = null;
        FileInputStream fileinput = null;
        try {
            fileinput = new FileInputStream(file);
            input = new BufferedInputStream(fileinput);
            OutputStream output = response.getOutputStream();

            int code = 0;
            while (code != -1) {
                code = input.read(buffer);
                output.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileinput != null) {
                try {
                    fileinput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return  ResultGenerator.genSuccessResult();

        }

    }

}

