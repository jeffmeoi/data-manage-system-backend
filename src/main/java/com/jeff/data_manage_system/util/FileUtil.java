package com.jeff.data_manage_system.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileUtil {

    public static final String CLASSPATH  = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    public static final String STATIC_PATH = CLASSPATH + "static" + File.separator;
    public static final String UPLOAD_PATH = STATIC_PATH + "upfile" + File.separator;
    public static final String TEMP_PATH = STATIC_PATH + "tmp" + File.separator;
    public static final String IMAGE_PATH  = FileUtil.UPLOAD_PATH + "img" + File.separator;
    public static final String THUMB_IMAGE_PATH  = IMAGE_PATH + "thumb" + File.separator;

    public static File transferTo(String destPath, String filename, MultipartFile file) throws IOException {
        File destDir = new File(destPath);
        if (!destDir.exists())
            destDir.mkdirs();
        File dest = new File( destDir.getPath() + File.separator + filename);
        file.transferTo(dest);
        return dest;
    }

    public static File copyTo(String destPath, String filename, File file) throws IOException {
        if(!file.exists())
            throw new FileNotFoundException();
        File destDir = new File(destPath);
        if (!destDir.exists())
            destDir.mkdirs();
        File dest = new File( destDir.getPath() + File.separator + filename);
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(file);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
        return dest;
    }
    /**
     * 根据文件扩展名判断文件是否图片格式
     *
     * @param extension 文件扩展名
     * @return
     */
    public static boolean isImage(String extension) {
        String[] imageExtension = new String[]{"jpeg", "jpg", "gif", "bmp", "png"};

        for (String e : imageExtension) if (extension.toLowerCase().equals(e)) return true;

        return false;
    }

    public static String getFileExtention(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

}
