package com.jeff.data_manage_system.service;

import com.jeff.data_manage_system.entity.User;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface RoleService {

    boolean isAdmin(User user);

    boolean isAdmin(HttpSession session);

    boolean isLogin(HttpSession session);

    boolean isSelf(HttpSession session, Integer id);

    Integer getSelfID(HttpSession session);

    List getRoleList();

    Map<String, Object> getRole(Integer id);

    String getRoleName(Integer id);

}

