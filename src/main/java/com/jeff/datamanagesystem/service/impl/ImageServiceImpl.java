package com.jeff.datamanagesystem.service.impl;

import com.jeff.datamanagesystem.dto.ImageFilterParams;
import com.jeff.datamanagesystem.entity.ImageInfo;
import com.jeff.datamanagesystem.exception.*;
import com.jeff.datamanagesystem.mapper.ImageInfoMapper;
import com.jeff.datamanagesystem.service.ImageService;
import com.jeff.datamanagesystem.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageInfoMapper imageInfoMapper;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        String ext = ImageUtil.getFileExtention(file.getOriginalFilename());
        if(!ImageUtil.isImage(ext))
            throw new FileTypeException();
        String fileName = String.format("%s.%s", UUID.randomUUID().toString(), ext);
        File uploadDir = new File(ImageUtil.IMAGE_PATH);
        if (!uploadDir.exists())
            uploadDir.mkdirs();
        file.transferTo(new File( uploadDir.getPath() + "\\"+fileName));
        return fileName;
    }


    @Override
    public String compressImage(String filename) throws IOException {
        ImageUtil.generateThumbnail2Directory(ImageUtil.THUMB_IMAGE_PATH, ImageUtil.IMAGE_PATH + filename);
        return ImageUtil.appendSuffix(filename, ImageUtil.SUFFIX);
    }

    @Override
    public int addImageInfo(ImageInfo imageInfo) {
        imageInfo.setCreateTime(new Date());
        imageInfo.setUpdateTime(imageInfo.getCreateTime());
        int result = imageInfoMapper.addImageInfo(imageInfo);
        return result;
    }

    @Override
    public int updateImageInfo(ImageInfo imageInfo) {
        imageInfo.setUpdateTime(new Date());
        int result = imageInfoMapper.updateImageInfo(imageInfo);
        return result;
    }

    @Override
    public int editImageInfo(ImageInfo imageInfo) {
        if(imageInfo.getId() == null)
            return addImageInfo(imageInfo);
        else
            return updateImageInfo(imageInfo);
    }

    @Override
    public int deleteImageInfo(Integer id) {
        int result = imageInfoMapper.deleteImageInfo(id);
        return result;
    }

    @Override
    public ImageInfo getImageInfo(Integer id) {
        ImageInfo imageInfo = imageInfoMapper.getImageInfo(id);
        if(imageInfo == null)
            throw new NullException();
        return imageInfo;
    }

    @Override
    public List<ImageInfo> getImageInfoList(ImageFilterParams imageFilterParams) {
        List<ImageInfo> imageInfoList = imageInfoMapper.getImageInfoList(imageFilterParams);
        if(imageInfoList == null)
            throw new NullException();
        return imageInfoList;
    }
}
