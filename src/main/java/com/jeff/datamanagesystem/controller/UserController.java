package com.jeff.datamanagesystem.controller;


import com.github.pagehelper.Page;
import com.jeff.datamanagesystem.dto.ErrorCode;
import com.jeff.datamanagesystem.dto.GetUserListParams;
import com.jeff.datamanagesystem.entity.User;
import com.jeff.datamanagesystem.enums.Role;
import com.jeff.datamanagesystem.exception.NoLoginException;
import com.jeff.datamanagesystem.service.RoleService;
import com.jeff.datamanagesystem.service.UserService;
import com.jeff.datamanagesystem.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PutMapping(value = "/login")
    public ErrorCode login(HttpSession session, String username, String password) throws LoginException {
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
        userService.addUser(user);
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
            throw new NoLoginException();
        userService.addUser(user);
        return ErrorCode.success();
    }

    @DeleteMapping(value = "/{id}")
    public ErrorCode deleteUser(HttpSession session, @PathVariable Integer id){
        if(!roleService.isAdmin(session))
            throw new NoLoginException();
        userService.deleteUser(id);
        return ErrorCode.success();
    }

    @PutMapping(value = "/{id}")
    public ErrorCode updateUser(HttpSession session, @PathVariable Integer id, @RequestBody User user){
        if(!roleService.isAdmin(session))
            throw new NoLoginException();
        userService.updateUser(user);
        return ErrorCode.success();
    }

    @GetMapping(value = "/{id}")
    public ErrorCode getUser(HttpSession session, @PathVariable Integer id){
        if(!roleService.isAdmin(session) && !roleService.isSelf(session, id))
            throw new NoLoginException();
        User user = userService.getUser(id);
        user.setStatusName(roleService.getRoleName(user.getStatus()));
        user.setPassword(null);
        return ErrorCode.success(user);
    }

    @PostMapping(value = "/list")
    public ErrorCode getUserList(HttpSession session, @RequestBody GetUserListParams params){
        if(!roleService.isAdmin(session))
            throw new NoLoginException();
        ListUtil.startPage(params.getListParams(), User.columns);
        return ErrorCode.success(ListUtil.getList((Page) userService.getUserList(params.getUser())));
    }

    @GetMapping(value = "/count")
    public ErrorCode getCount(HttpSession session){
        if(!roleService.isAdmin(session))
            throw new NoLoginException();
        return ErrorCode.success(userService.getTotalCount());
    }


    @PostMapping(value = "/batch")
    public ErrorCode batchAddUser(HttpSession session, @RequestParam("file") MultipartFile file[]){

        return ErrorCode.success();
    }


}
