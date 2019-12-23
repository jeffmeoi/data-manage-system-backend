package com.jeff.data_manage_system.controller;

import com.jeff.data_manage_system.dto.ErrorCode;
import com.jeff.data_manage_system.entity.Type;
import com.jeff.data_manage_system.exception.AccessException;
import com.jeff.data_manage_system.exception.NoLoginException;
import com.jeff.data_manage_system.service.ImageService;
import com.jeff.data_manage_system.service.RoleService;
import com.jeff.data_manage_system.service.TypeService;
import com.jeff.data_manage_system.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/type")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "")
    public ErrorCode addType(HttpSession session, @RequestBody Type type){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        typeService.addType(type, roleService.getSelfID(session));
        return ErrorCode.success();
    }

    @DeleteMapping(value = "/{id}")
    public ErrorCode deleteType(HttpSession session, @PathVariable Integer id){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        typeService.deleteType(id);
        return ErrorCode.success();
    }

    @PutMapping(value = "/{id}")
    public ErrorCode updateType(HttpSession session, @PathVariable Integer id, @RequestBody Type type){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        typeService.updateType(type);
        return ErrorCode.success();
    }

    @GetMapping(value = "/{id}")
    public ErrorCode getType(HttpSession session, @PathVariable Integer id){
        if(!roleService.isLogin(session))
            throw new NoLoginException();
        return ErrorCode.success(typeService.getType(id));
    }

    @GetMapping(value = "/list")
    public ErrorCode getTypeList(HttpSession session){
        if(!roleService.isLogin(session))
            throw new NoLoginException();
        return ErrorCode.success(typeService.getTypeList());
    }

    @GetMapping(value = "/count")
    public ErrorCode getCount(HttpSession session){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        return ErrorCode.success(typeService.getCount());
    }

    @PostMapping(value = "/batch")
    public ErrorCode addTypes(HttpSession session, @RequestParam("files") MultipartFile files[]) throws IOException {
        if(!roleService.isAdmin(session))
            throw new AccessException();
        for(int i = 0; i < files.length; i++){
            if (files[i].isEmpty())
                throw new FileNotFoundException();
            String ext = FileUtil.getFileExtention(files[i].getOriginalFilename());
            File dest = FileUtil.transferTo(FileUtil.TEMP_PATH, String.format("%s.%s", UUID.randomUUID().toString(), ext), files[i]);
            typeService.addTypes(dest, roleService.getSelfID(session));
        }
        return ErrorCode.success();
    }
}
