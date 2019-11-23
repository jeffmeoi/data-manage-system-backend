package com.jeff.datamanagesystem.controller;

import com.jeff.datamanagesystem.dto.ErrorCode;
import com.jeff.datamanagesystem.entity.Type;
import com.jeff.datamanagesystem.exception.NoLoginException;
import com.jeff.datamanagesystem.service.ImageService;
import com.jeff.datamanagesystem.service.RoleService;
import com.jeff.datamanagesystem.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            throw new NoLoginException();
        typeService.addType(type);
        return ErrorCode.success();
    }

    @DeleteMapping(value = "/{id}")
    public ErrorCode deleteType(HttpSession session, @PathVariable Integer id){
        if(!roleService.isAdmin(session))
            throw new NoLoginException();
        typeService.deleteType(id);
        return ErrorCode.success();
    }

    @PutMapping(value = "/{id}")
    public ErrorCode updateType(HttpSession session, @PathVariable Integer id, @RequestBody Type type){
        if(!roleService.isAdmin(session))
            throw new NoLoginException();
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
            throw new NoLoginException();
        return ErrorCode.success(typeService.getCount());
    }

    @PostMapping(value = "/batch")
    public ErrorCode batchAddType(HttpSession session, @RequestParam("file") MultipartFile file[]){

        return ErrorCode.success();
    }
}
