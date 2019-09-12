package com.acghome.controller;


import com.acghome.utils.Result;
import com.acghome.utils.ResultGenerator;
import com.acghome.entity.db1.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping(value = "/user")

public class UserController {

    private static String FOLDER = "/Users/tmh/Documents/code project/webdemo/src/main/resources/temp/";

    @Autowired
    private com.acghome.service.IUserService IUserService;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/rush")
    @ResponseBody
    public String getUserdefault() {
        logger.info("看看执行没有");
        return "hello world";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addUser(@RequestBody User user) {

        logger.info(user.toString());
//        IUserService.addUser(user);

        return ResultGenerator.genFailResult("test");
    }

//    @ResponseBody
//    @RequestMapping(value = "/add2", method = RequestMethod.POST)
//    public Map addUser2(@RequestBody Map<String, Object> user) {
//
//        User usertmp = new User();
//
//        Integer money = (Integer) user.get("money");
//        usertmp.setMoney(Double.valueOf(money.doubleValue()));
//        usertmp.setName((String) user.get("name"));
//        usertmp.setAge((Integer) user.get("age"));
//
//        logger.info(user.toString());
//        IUserService.addUser(usertmp);
//
//        user.put("new", "haha");
//
//        return user;
//}


  /*  @ResponseBody
    @RequestMapping(value = "{id}")
    public Object getUser(@PathVariable int id) {

//        User user=IUserService.getUserById(id);
        return ResultGenerator.genSuccessResult(user);
    }
*/

    @ResponseBody
    @RequestMapping(value = "/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile fileinput) {

        if (fileinput.isEmpty()) {

            return "error Please select a file to upload";
        }

        try {
            Path path = Paths.get(FOLDER + fileinput.getOriginalFilename());

            Files.write(path, fileinput.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ok";

    }

    @ResponseBody
    @GetMapping("download")
    public String downloadFile(HttpServletResponse response) {
        String fileName = "20190902114314.jpg";
        String filePath = FOLDER + fileName;

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

        //分页
//    @ResponseBody
//    @RequestMapping(value = "/page_id/{page_id}")
//    public List<User> getUserByPage(@PathVariable int page_id){
//
//        return  IUserService.getUserPage(page_id);
//
// }