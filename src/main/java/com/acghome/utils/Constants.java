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

    //public static final String IMG_PATH="/Users/tmh/Documents/code project/webdemo/src/main/resources/temp/";



    public static Path getImgPath() {

        Path path = getClassPath().resolve("temp");

        return path;
    }


    public static Path getClassPath() {
        URL url = Constants.class.getClassLoader().getResource("");
        String urlpath = null;

        try {
            assert url != null;
            urlpath = URLDecoder.decode(url.getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(urlpath);

        return path;
    }

}
