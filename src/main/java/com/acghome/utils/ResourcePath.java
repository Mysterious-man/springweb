package com.acghome.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author tmh
 * @version 1.0.0
 * @ClassName ResourcePath.java
 * @Description TODO
 * @createTime 2019年09月14日 23:39:00
 */
public class ResourcePath {



    //图片相对路径（用于url访问，数据库存该路径）: /static/image
    public static Path getImgPath() {

        Path path = Paths.get("static").resolve("image");

        return path;
    }


    //图片存储的绝对路径在webapp下的static/image文件夹
    public static Path getImgAbsPath(HttpServletRequest request) {

        Path path = getWebResourceUrl(request).resolve("static").resolve("image");

        return path;
    }


    //文件存储的绝对路径在webapp下的static/file文件夹
    public static Path getfileAbsPath(HttpServletRequest request) {

        Path path = getWebResourceUrl(request).resolve("static").resolve("file");

        return path;
    }



    //获取webapp下的路径
    public static Path getWebResourceUrl(HttpServletRequest request) {

        String realPath = null;
        try {
            realPath = request.getSession().getServletContext().getResource("").getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String os = System.getProperty("os.name");

        //win系统的绝对路径第一个字符没有/，所以去掉
        if(os.toLowerCase().startsWith("win")){
            realPath=realPath.substring(1,realPath.length()-1);
        }

        try {
            realPath = URLDecoder.decode(realPath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Path path = Paths.get(realPath);

        return path;
    }



    // 获取classes目录路径
    public static Path getClassPath() {
        String url = ResourcePath.class.getClassLoader().getResource("").getPath();
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
