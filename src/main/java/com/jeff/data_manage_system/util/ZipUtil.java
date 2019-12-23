package com.jeff.data_manage_system.util;

import com.jeff.data_manage_system.exception.UnzipException;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    private static final int BUFFER_SIZE = 512;

    public static File generateZip(String path, String filename) throws Exception {
        File file = new File(path);
        if(!file.exists())
            throw new FileNotFoundException();
        File dest = new File(FileUtil.TEMP_PATH + filename);
        ZipOutputStream zipOutputStream  = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(dest)));
        generateFile(zipOutputStream, file, "");
        zipOutputStream.close();
        return dest;
    }

    private static void generateFile(ZipOutputStream out, File file, String dir) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            out.putNextEntry(new ZipEntry(dir + "/"));
            dir = dir.length() == 0 ? "" : dir + "/";
            for (int i = 0; i < files.length; i++) {
                generateFile(out, files[i], dir + files[i].getName());
            }
        } else {
            FileInputStream inputStream = new FileInputStream(file);
            out.putNextEntry(new ZipEntry(dir));
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) > 0) {
                out.write(bytes, 0, len);
            }
            inputStream.close();
        }
    }


    public static String unZip(File srcFile, String destDirPath) throws FileNotFoundException, UnzipException {
        if (!srcFile.exists())
            throw new FileNotFoundException();
        ZipFile zipFile = null;
        String rootEntry = null;
        try {
            zipFile = new ZipFile(srcFile);
            rootEntry = zipFile.entries().nextElement().getName();
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                if (entry.isDirectory()) {
                    String dirPath = destDirPath + "/" + entry.getName();
                    File dir = new File(dirPath);
                    if(!dir.exists())
                        dir.mkdirs();
                } else {
                    File targetFile = new File(destDirPath + "/" + entry.getName());
                    if(!targetFile.getParentFile().exists()){
                        targetFile.getParentFile().mkdirs();
                    }
                    targetFile.createNewFile();
                    InputStream is = zipFile.getInputStream(entry);
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    int len;
                    byte[] buf = new byte[BUFFER_SIZE];
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.close();
                    is.close();
                }
            }
        } catch (Exception e) {
            throw new UnzipException();
        } finally {
            if(zipFile != null){
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return rootEntry;
    }

}
