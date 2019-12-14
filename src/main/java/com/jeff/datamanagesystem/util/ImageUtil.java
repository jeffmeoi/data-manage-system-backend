package com.jeff.datamanagesystem.util;

import com.github.pagehelper.PageHelper;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片压缩工具类
 *
 * @author lnj
 * createTime 2018-10-19 15:31
 **/
public class ImageUtil {

    private static final String IMAGE_PATH  = FileUtil.IMAGE_PATH;
    private static final String THUMB_IMAGE_PATH  = FileUtil.THUMB_IMAGE_PATH;
    public static final String SUFFIX = "-thumbnail";

    private static final double DEFAULT_SCALE = 0.8d;

    /**
     * 生成缩略图到指定的目录
     *
     * @param path  目录
     * @param files 要生成缩略图的文件列表
     * @throws IOException
     */
    public static List<String> generateThumbnail2Directory(String path, String... files) throws IOException {
        File thumbDir = new File(path);
        if(!thumbDir.exists())
            thumbDir.mkdirs();
        Thumbnails.of(files).size(300, 300).toFiles(thumbDir, Rename.SUFFIX_HYPHEN_THUMBNAIL);
        List<String> list = new ArrayList<>(files.length);
        for (String file : files) {
            list.add(appendSuffix(file, SUFFIX));
        }
        return list;
    }

    /**
     * 生成缩略图到指定的目录
     *
     * @param scale    图片缩放率
     * @param pathname 缩略图保存目录
     * @param files    要生成缩略图的文件列表
     * @throws IOException
     */
    public static List<String> generateThumbnail2Directory(double scale, String pathname, String... files) throws IOException {
        Thumbnails.of(files).scale(scale).toFiles(new File(pathname), Rename.SUFFIX_HYPHEN_THUMBNAIL);
        List<String> list = new ArrayList<>(files.length);
        for (String file : files) {
            list.add(appendSuffix(file, SUFFIX));
        }
        return list;
    }

    /**
     * 将指定目录下所有图片生成缩略图
     *
     * @param pathname 文件目录
     */
    public static void generateDirectoryThumbnail(String pathname) throws IOException {
        generateDirectoryThumbnail(pathname, DEFAULT_SCALE);
    }

    /**
     * 将指定目录下所有图片生成缩略图
     *
     * @param pathname 文件目录
     */
    public static void generateDirectoryThumbnail(String pathname, double scale) throws IOException {
        File[] files = new File(pathname).listFiles();
        compressRecurse(files, pathname);
    }

    /**
     * 文件追加后缀
     *
     * @param fileName 原文件名
     * @param suffix   文件后缀
     * @return
     */
    public static String appendSuffix(String fileName, String suffix) {
        String newFileName = "";

        int indexOfDot = fileName.lastIndexOf('.');

        if (indexOfDot != -1) {
            newFileName = fileName.substring(0, indexOfDot);
            newFileName += suffix;
            newFileName += fileName.substring(indexOfDot);
        } else {
            newFileName = fileName + suffix;
        }

        return newFileName;
    }

    /**
     * 压缩文件数组
     * @param files
     * @param pathname
     * @throws IOException
     */
    private static void compressRecurse(File[] files, String pathname) throws IOException {
        for (File file : files) {
            if (file.isDirectory()) {
                File[] subFiles = file.listFiles();
                compressRecurse(subFiles, pathname + File.separator + file.getName());
            } else {
                String extension = FileUtil.getFileExtention(file.getName());
                if (!file.getName().contains(SUFFIX) && FileUtil.isImage(extension)) {
                    generateThumbnail2Directory(pathname, file.getAbsolutePath());
                }
            }
        }
    }

}