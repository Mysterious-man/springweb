package com.acghome.controller;


import com.acghome.utils.Constants;
import com.acghome.utils.Result;
import com.acghome.utils.ResultGenerator;
import com.acghome.entity.db1.User;
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
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;


@Controller
@RequestMapping(value = "/picture")

public class PictureController {



    @Autowired
    private com.acghome.service.IUserService IUserService;

    private final static Logger logger = LoggerFactory.getLogger(PictureController.class);



    @ResponseBody
    @RequestMapping(value = "/upload")
    public Result saveUpload(@RequestParam("file") MultipartFile fileinput, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("").replace("webapp\\","")+"resources\\temp\\";
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
        String filePath =realPath + fileName;


        try {
            Path path = Paths.get(filePath);

            Files.write(path, fileinput.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("上传图片失败");
        }

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("url",fileName);
        map.put("IMG_PATH",filePath);
        return ResultGenerator.genSuccessResult(map);

    }



    @ResponseBody
    @GetMapping("download")
    public String downloadFile(HttpServletResponse response) {
        String fileName = "20190902114314.jpg";
        String filePath = Constants.IMG_PATH + fileName;

        File file = new File(filePath);

        if (!file.exists()) {
            return "error file miss";
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
            return "ok";

        }

    }

}

