package com.jeff.datamanagesystem.service;

import com.jeff.datamanagesystem.entity.User;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface RoleService {

    boolean isAdmin(User user);

    boolean isAdmin(HttpSession session);

    boolean isLogin(HttpSession session);

    boolean isSelf(HttpSession session, Integer id);

    List getRoleList();

    Map<String, Object> getRole(Integer id);

    String getRoleName(Integer id);

}

