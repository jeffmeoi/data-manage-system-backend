package com.jeff.datamanagesystem.service;

import com.jeff.datamanagesystem.dto.ImageFilterParams;
import com.jeff.datamanagesystem.entity.ImageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ImageService {

    String uploadImage(MultipartFile file) throws IOException;
    String compressImage(String filename) throws IOException;
    int addImageInfo(ImageInfo imageInfo);
    int updateImageInfo(ImageInfo imageInfo);
    int editImageInfo(ImageInfo imageInfo);
    int deleteImageInfo(Integer id);
    ImageInfo getImageInfo(Integer id);
    List<ImageInfo> getImageInfoList(ImageFilterParams imageFilterParams);

}
