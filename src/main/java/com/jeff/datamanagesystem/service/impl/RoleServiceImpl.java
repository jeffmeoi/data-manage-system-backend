package com.jeff.datamanagesystem.service.impl;

import com.jeff.datamanagesystem.entity.User;
import com.jeff.datamanagesystem.enums.Role;
import com.jeff.datamanagesystem.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Override
    public boolean isAdmin(User user){
        return user.getStatus() == Role.ADMIN.getStatus();
    }

    @Override
    public boolean isAdmin(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null)
            return false;
        return user.getStatus() == Role.ADMIN.getStatus();
    }

    @Override
    public boolean isLogin(HttpSession session){
        return session.getAttribute("user") != null;
    }

    @Override
    public boolean isSelf(HttpSession session, Integer id) {
        System.out.println(session);
        System.out.println(id);
        return ((User)session.getAttribute("user")).getId().equals(id);
    }

    @Override
    public List getRoleList(){
        List<Map> list = new LinkedList<>();
        for(Role role : Role.values()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", role.getName());
            map.put("status", role.getStatus());
            list.add(map);
        }
        return list;
    }

    @Override
    public Map<String, Object> getRole(Integer id){
        List<Map> roleList = getRoleList();
        for(Map role : roleList)
            if(id != null && id.equals(role.get("status")))
                return role;
        return null;
    }

    @Override
    public String getRoleName(Integer id){
        Map role = getRole(id);
        return (String) role.get("name");
    }

}
