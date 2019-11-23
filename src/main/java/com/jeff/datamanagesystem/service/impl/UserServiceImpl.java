package com.jeff.datamanagesystem.service.impl;

import com.jeff.datamanagesystem.entity.User;
import com.jeff.datamanagesystem.exception.*;
import com.jeff.datamanagesystem.mapper.UserMapper;
import com.jeff.datamanagesystem.service.UserService;
import com.jeff.datamanagesystem.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;
import java.util.*;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List getTotalCount() {
        List list = new LinkedList();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Total");
        map.put("count", userMapper.getTotalCount());
        list.add(map);
        return list;
    }

    @Override
    public int addUser(User user) {
        user.setId(null);
        user.setCreateTime(new Date());
        user.setUpdateTime(user.getCreateTime());
        System.out.println(user.getPassword());
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        System.out.println(user.getPassword());
        int result = userMapper.addUser(user);
        return result;
    }

    @Override
    public int updateUser(User user) {
        if(user.getId() == null)
            throw new NullException();
        user.setUpdateTime(new Date());

        int result;
        if(user.getPassword() == null)
            result = userMapper.updateUserWithoutPassword(user);
        else
            result =  userMapper.updateUser((user));
        return result;
    }

    @Override
    public int editUser(User user) {
        if(user.getId() == null)
            return addUser(user);
        else
            return updateUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        int result = userMapper.deleteUser(id);
        return result;
    }

    @Override
    public User getUser(Integer id) {
        User user = userMapper.getUserByID(id);
        return user;
    }

    @Override
    public User getUser(String username) {
        User user = userMapper.getUserByUsername(username);
        return user;
    }

    @Override
    public List<User> getUserList(User user) {
        List<User> userList = userMapper.getUserList(user);
        return userList;
    }

    @Override
    public int login(HttpSession session, String username, String password) throws LoginException {
        User user = getUser(username);
        if(user == null)
            throw new  NullException();
        if(!MD5Util.getMD5(password).equals(user.getPassword()))
            throw new LoginException();
        session.setAttribute("user", user);
        return user.getId();
    }

    @Override
    public int getLoginID(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user.getId();
    }

    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }

}
