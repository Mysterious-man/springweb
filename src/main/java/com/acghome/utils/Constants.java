package com.acghome.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName Constants.java
 * @Description TODO
 * @createTime 2019年09月14日 23:39:00
 */
public class Constants {


    //图片路径在classpath下的temp文件夹
    public static Path getImgPath() {

        Path path = getClassPath().resolve("temp");

        return path;
    }


    public static Path getClassPath() {
        String url = Constants.class.getClassLoader().getResource("").getPath();
        String urlpath = null;
        String os = System.getProperty("os.name");

        //win系统的绝对路径第一个字符没有/，所以去掉
        if(os.toLowerCase().startsWith("win")){
            url=url.substring(1,url.length()-1);
        }

        try {
            urlpath = URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(urlpath);

        return path;
    }

}
