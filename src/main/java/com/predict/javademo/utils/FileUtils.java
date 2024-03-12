package com.predict.javademo.utils;

import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class FileUtils {
    public static String write(String dirPath, MultipartFile originImg) {
        String originImgName = originImg.getOriginalFilename();
        String type = originImgName.substring(originImgName.lastIndexOf("."));
        String id = UUID.randomUUID().toString();

        File file = new File(dirPath + id + type);

        try {
            originImg.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dirPath + id + type;
    }

    public static String readAsBase64(String path) {
        byte[] buffer = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64Utils.encodeToString(buffer);
    }

    public static Boolean delete(String path) {
        File file = new File(path);
        return file.delete();
    }

}
