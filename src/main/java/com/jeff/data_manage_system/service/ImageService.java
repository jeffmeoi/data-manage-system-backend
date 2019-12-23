package com.jeff.data_manage_system.service;

import com.jeff.data_manage_system.dto.ImageFilterParams;
import com.jeff.data_manage_system.entity.ImageInfo;
import com.jeff.data_manage_system.exception.UnzipException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface ImageService {

    String uploadImage(MultipartFile file) throws IOException;
    String compressImage(String filename) throws IOException;
    int addImageInfo(ImageInfo imageInfo, Integer userID);
    void addImages(File zip, Integer userID) throws IOException, UnzipException, ParseException;
    int updateImageInfo(ImageInfo imageInfo);
    int editImageInfo(ImageInfo imageInfo, Integer userID);
    int deleteImageInfo(Integer id);
    ImageInfo getImageInfo(Integer id);
    List<ImageInfo> getImageInfoList(ImageFilterParams imageFilterParams);

}
