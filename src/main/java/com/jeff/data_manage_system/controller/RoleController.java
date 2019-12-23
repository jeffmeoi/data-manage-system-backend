package com.jeff.data_manage_system.controller;

import com.jeff.data_manage_system.dto.ErrorCode;
import com.jeff.data_manage_system.service.RoleService;
import com.jeff.data_manage_system.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/list")
    public ErrorCode getRoleList(HttpSession session){
        return ErrorCode.success(roleService.getRoleList());
    }

    @GetMapping(value = "/{id}")
    public ErrorCode getRole(HttpSession session, @PathVariable Integer id){
        return ErrorCode.success(roleService.getRole(id));
    }

    @GetMapping(value = "/{id}/name")
    public ErrorCode getRoleName(HttpSession session, @PathVariable Integer id){
        return ErrorCode.success(roleService.getRoleName(id));
    }

}
