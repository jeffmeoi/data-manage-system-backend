package com.jeff.datamanagesystem.controller;


import com.github.pagehelper.Page;
import com.jeff.datamanagesystem.dto.ErrorCode;
import com.jeff.datamanagesystem.dto.GetUserListParams;
import com.jeff.datamanagesystem.entity.User;
import com.jeff.datamanagesystem.enums.Role;
import com.jeff.datamanagesystem.exception.AccessException;
import com.jeff.datamanagesystem.exception.NoLoginException;
import com.jeff.datamanagesystem.service.RoleService;
import com.jeff.datamanagesystem.service.UserService;
import com.jeff.datamanagesystem.util.FileUtil;
import com.jeff.datamanagesystem.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PutMapping(value = "/login")
    public ErrorCode login(HttpSession session, @RequestParam String username, @RequestParam String password) throws LoginException {
        Integer userID = userService.login(session, username, password);
        return ErrorCode.success(userID);
    }

    @GetMapping(value = "/login")
    public ErrorCode getLoginID(HttpSession session){
        if(!roleService.isLogin(session))
            throw new NoLoginException();
        return ErrorCode.success(userService.getLoginID(session));
    }

    @PostMapping(value = "/register")
    public ErrorCode register(HttpSession session, @RequestBody User user) {
        user.setStatus(Role.USER.getStatus());
        userService.addUser(user, roleService.getSelfID(session));
        return ErrorCode.success();
    }

    @PutMapping(value = "/logout")
    public ErrorCode logout(HttpSession session) {
        if(!roleService.isLogin(session))
            throw new NoLoginException();
        userService.logout(session);
        return ErrorCode.success();
    }


    @PostMapping(value = "")
    public ErrorCode addUser(HttpSession session, @RequestBody User user){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        userService.addUser(user, roleService.getSelfID(session));
        return ErrorCode.success();
    }

    @DeleteMapping(value = "/{id}")
    public ErrorCode deleteUser(HttpSession session, @PathVariable Integer id){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        userService.deleteUser(id);
        return ErrorCode.success();
    }

    @PutMapping(value = "/{id}")
    public ErrorCode updateUser(HttpSession session, @PathVariable Integer id, @RequestBody User user){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        userService.updateUser(user);
        return ErrorCode.success();
    }

    @GetMapping(value = "/{id}")
    public ErrorCode getUser(HttpSession session, @PathVariable Integer id){
        if(!roleService.isAdmin(session) && !roleService.isSelf(session, id))
            throw new AccessException();
        User user = userService.getUser(id);
        user.setStatusName(roleService.getRoleName(user.getStatus()));
        user.setPassword(null);
        return ErrorCode.success(user);
    }

    @PostMapping(value = "/list")
    public ErrorCode getUserList(HttpSession session, @RequestBody GetUserListParams params){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        ListUtil.startPage(params.getListParams(), User.columns);
        return ErrorCode.success(ListUtil.getList((Page) userService.getUserList(params.getUser())));
    }

    @GetMapping(value = "/count")
    public ErrorCode getCount(HttpSession session){
        if(!roleService.isAdmin(session))
            throw new AccessException();
        return ErrorCode.success(userService.getTotalCount());
    }

    @PostMapping(value = "/batch")
    public ErrorCode addUsers(HttpSession session, @RequestParam("files") MultipartFile files[]) throws IOException {
        if(!roleService.isAdmin(session))
            throw new AccessException();
        for(int i = 0; i < files.length; i++) {
            if (files[i].isEmpty())
                throw new FileNotFoundException();
            String ext = FileUtil.getFileExtention(files[i].getOriginalFilename());
            File dest = FileUtil.transferTo(FileUtil.TEMP_PATH, String.format("%s.%s", UUID.randomUUID().toString(), ext), files[i]);
            userService.addUsers(dest, roleService.getSelfID(session));
        }
        return ErrorCode.success();
    }


}
