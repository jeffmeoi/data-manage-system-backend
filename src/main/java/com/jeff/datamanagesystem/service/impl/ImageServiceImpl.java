package com.jeff.datamanagesystem.service.impl;

import com.jeff.datamanagesystem.dto.ImageFilterParams;
import com.jeff.datamanagesystem.entity.ImageInfo;
import com.jeff.datamanagesystem.entity.Type;
import com.jeff.datamanagesystem.exception.*;
import com.jeff.datamanagesystem.mapper.ImageInfoMapper;
import com.jeff.datamanagesystem.mapper.TypeMapper;
import com.jeff.datamanagesystem.service.ImageService;
import com.jeff.datamanagesystem.util.ExcelUtil;
import com.jeff.datamanagesystem.util.FileUtil;
import com.jeff.datamanagesystem.util.ImageUtil;
import com.jeff.datamanagesystem.util.ZipUtil;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageInfoMapper imageInfoMapper;
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        String ext = FileUtil.getFileExtention(file.getOriginalFilename());
        if(!FileUtil.isImage(ext))
            throw new FileTypeException();
        String fileName = String.format("%s.%s", UUID.randomUUID().toString(), ext);
        FileUtil.transferTo(FileUtil.IMAGE_PATH, fileName, file);
        return fileName;
    }


    @Override
    public String compressImage(String filename) throws IOException {
        ImageUtil.generateThumbnail2Directory(FileUtil.THUMB_IMAGE_PATH, FileUtil.IMAGE_PATH + filename);
        return ImageUtil.appendSuffix(filename, ImageUtil.SUFFIX);
    }

    @Override
    public int addImageInfo(ImageInfo imageInfo, Integer userID) {
        imageInfo.setUserID(userID);
        imageInfo.setCreateTime(new Date());
        imageInfo.setUpdateTime(imageInfo.getCreateTime());
        int result = imageInfoMapper.addImageInfo(imageInfo);
        return result;
    }

    @Override
    public void addImages(File zip, Integer userID) throws IOException, UnzipException, ParseException {
        String ext = FileUtil.getFileExtention(zip.getName());
        String filenameWithoutExt = zip.getName().substring(0, zip.getName().length() - ext.length() - 1);
        String destPath = FileUtil.TEMP_PATH + File.separator + filenameWithoutExt;
        String rootEntry = ZipUtil.unZip(zip, destPath);
        File excel = new File(destPath + File.separator + "ImageInfo.xlsx");
        String imageDir = destPath + File.separator + "img" + File.separator;
        readImageExcel(excel, imageDir, userID);
        File dest = new File(destPath);
        dest.delete();
    }

    public void readImageExcel(File excel, String imageDir, Integer userID) throws IOException, ParseException {
        Iterator rows = ExcelUtil.getRowIterator(excel);
        rows.next();
        while(rows.hasNext()) {
            List<String> cellValues = ExcelUtil.getCellValues((Row) rows.next());
            String imageName = cellValues.get(0);
            File image = new File(imageDir + File.separator + imageName);
            String ext = FileUtil.getFileExtention(image.getName());
            if(!FileUtil.isImage(ext))
                throw new FileTypeException();
            String filename = String.format("%s.%s", UUID.randomUUID().toString(), ext);
            FileUtil.copyTo(FileUtil.IMAGE_PATH, filename, image);

            String url = "/upfile/img/" + filename;
            String thumbUrl = "/upfile/img/thumb/" + compressImage(filename);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String country = cellValues.get(1);
            String position = cellValues.get(2);
            String type = cellValues.get(3);
            Double ppi = Double.parseDouble(cellValues.get(4));
            Double longitude = Double.parseDouble(cellValues.get(5));
            Double latitude = Double.parseDouble(cellValues.get(6));
            Date gatherTime = simpleDateFormat.parse(cellValues.get(7));
            Integer gatherDuration = Integer.parseInt(cellValues.get(8));
            Double scale = Double.parseDouble(cellValues.get(9));
            Integer typeID = typeMapper.getTypeIDbyName(type);
            if(typeID == null) {
                Type newType = new Type(null, type, null, userID, new Date(), new Date());
                typeMapper.addType(newType);
                typeID = newType.getId();
            }

            ImageInfo imageInfo = new ImageInfo(null, country, position, typeID, ppi,
                    longitude, latitude, gatherTime, gatherDuration,
                    scale, url, thumbUrl, null, null, null);
            addImageInfo(imageInfo, userID);
        }
    }

    @Override
    public int updateImageInfo(ImageInfo imageInfo) {
        imageInfo.setUpdateTime(new Date());
        int result = imageInfoMapper.updateImageInfo(imageInfo);
        return result;
    }

    @Override
    public int editImageInfo(ImageInfo imageInfo, Integer userID) {
        if(imageInfo.getId() == null)
            return addImageInfo(imageInfo, userID);
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
