package com.jeff.datamanagesystem.controller;

import com.github.pagehelper.Page;
import com.jeff.datamanagesystem.dto.ErrorCode;
import com.jeff.datamanagesystem.dto.GetImageInfoListParams;
import com.jeff.datamanagesystem.entity.ImageInfo;
import com.jeff.datamanagesystem.exception.AccessException;
import com.jeff.datamanagesystem.exception.FileTypeException;
import com.jeff.datamanagesystem.exception.NoLoginException;
import com.jeff.datamanagesystem.exception.UnzipException;
import com.jeff.datamanagesystem.service.ImageService;
import com.jeff.datamanagesystem.service.RoleService;
import com.jeff.datamanagesystem.util.FileUtil;
import com.jeff.datamanagesystem.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private RoleService roleService;


    @PostMapping(value = "")
    public ErrorCode addImage(HttpSession session, @RequestBody ImageInfo imageInfo){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        imageService.addImageInfo(imageInfo, roleService.getSelfID(session));
        return ErrorCode.success();
    }

    @DeleteMapping(value = "/{id}")
    public ErrorCode deleteImage(HttpSession session, @PathVariable Integer id){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        imageService.deleteImageInfo(id);
        return ErrorCode.success();
    }

    @PutMapping(value = "/{id}")
    public ErrorCode updateImage(HttpSession session, @PathVariable Integer id, @RequestBody ImageInfo imageInfo){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        imageInfo.setId(id);
        imageService.updateImageInfo(imageInfo);
        return ErrorCode.success();
    }

    @GetMapping(value = "/{id}")
    public ErrorCode getImageInfo(HttpSession session, @PathVariable Integer id){
        if(!roleService.isLogin(session))
            throw new NoLoginException();
        return ErrorCode.success(imageService.getImageInfo(id));
    }

    @PostMapping(value = "/list")
    public ErrorCode getImageInfoList(HttpSession session, @RequestBody GetImageInfoListParams params){
        if(!roleService.isLogin(session))
            throw new NoLoginException();
        ListUtil.startPage(params.getListParams(), ImageInfo.columns);
        return ErrorCode.success(ListUtil.getList((Page) imageService.getImageInfoList(params.getImageFilterParams())));
    }

    @PostMapping(value = "/upload")
    public ErrorCode uploadImage(HttpSession session, @RequestParam("file") MultipartFile file) throws IOException {
        if(!roleService.isAdmin(session))
            throw new AccessException();
        if (file.isEmpty())
            throw new FileNotFoundException();
        Map<String, String> map = new HashMap<>();
        String filename = imageService.uploadImage(file);
        map.put("url", "/upfile/img/" + filename);
        map.put("thumbUrl", "/upfile/img/thumb/" + imageService.compressImage(filename));
        return ErrorCode.success(map);
    }

    @PostMapping(value = "/batch")
    public ErrorCode addImages(HttpSession session, @RequestParam("files") MultipartFile files[]) throws IOException, UnzipException, ParseException {
        for(int i = 0; i < files.length; i++)
            System.out.println(files[i]);
        if(!roleService.isAdmin(session))
            throw new AccessException();
        for(int i = 0; i < files.length; i++){
            if (files[i].isEmpty())
                throw new FileNotFoundException();
            String ext = FileUtil.getFileExtention(files[i].getOriginalFilename());
            System.out.println(ext);
            if(!ext.equals("zip"))
                throw new FileTypeException();
            File dest = FileUtil.transferTo(FileUtil.TEMP_PATH, String.format("%s.%s", UUID.randomUUID().toString(), ext), files[i]);
            imageService.addImages(dest, roleService.getSelfID(session));
        }
        return ErrorCode.success();
    }
}
