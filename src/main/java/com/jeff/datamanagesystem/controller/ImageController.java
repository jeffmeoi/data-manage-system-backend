package com.jeff.datamanagesystem.controller;

import com.github.pagehelper.Page;
import com.jeff.datamanagesystem.dto.ErrorCode;
import com.jeff.datamanagesystem.dto.GetImageInfoListParams;
import com.jeff.datamanagesystem.entity.ImageInfo;
import com.jeff.datamanagesystem.exception.NoLoginException;
import com.jeff.datamanagesystem.service.ImageService;
import com.jeff.datamanagesystem.service.RoleService;
import com.jeff.datamanagesystem.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
            throw new NoLoginException();
        imageService.addImageInfo(imageInfo);
        return ErrorCode.success();
    }

    @DeleteMapping(value = "/{id}")
    public ErrorCode deleteImage(HttpSession session, @PathVariable Integer id){
        if(!roleService.isAdmin(session))
            throw new NoLoginException();
        imageService.deleteImageInfo(id);
        return ErrorCode.success();
    }

    @PutMapping(value = "/{id}")
    public ErrorCode updateImage(HttpSession session,@PathVariable Integer id, @RequestBody ImageInfo imageInfo){
        if(!roleService.isAdmin(session))
            throw new NoLoginException();
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
        if(!roleService.isLogin(session))
            throw new NoLoginException();
        if (file.isEmpty())
            throw new FileNotFoundException();
        Map<String, String> map = new HashMap<>();
        String filename = imageService.uploadImage(file);
        map.put("url", "/upfile/img/" + filename);
        map.put("thumbUrl", "/upfile/img/thumb/" + imageService.compressImage(filename));
        return ErrorCode.success(map);
    }

    @PostMapping(value = "/batch")
    public ErrorCode batchAddImage(HttpSession session, @RequestParam("file") MultipartFile file[]){

        return ErrorCode.success();
    }
}
