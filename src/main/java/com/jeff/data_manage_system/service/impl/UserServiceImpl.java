package com.jeff.data_manage_system.service.impl;

import com.jeff.data_manage_system.entity.User;
import com.jeff.data_manage_system.enums.Role;
import com.jeff.data_manage_system.exception.*;
import com.jeff.data_manage_system.mapper.UserMapper;
import com.jeff.data_manage_system.service.UserService;
import com.jeff.data_manage_system.util.ExcelUtil;
import com.jeff.data_manage_system.util.MD5Util;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
    public int addUser(User user, Integer userID) {
        user.setId(userID);
        user.setCreateTime(new Date());
        user.setUpdateTime(user.getCreateTime());
        user.setCreatorID(userID);
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userMapper.addUser(user);
    }

    @Override
    public void addUsers(File file, Integer userID) throws IOException {
        Iterator rows = ExcelUtil.getRowIterator(file);
        rows.next();
        while(rows.hasNext()) {
            List<String> cellValues = ExcelUtil.getCellValues((Row) rows.next());
            String username = cellValues.get(0);
            String password = cellValues.get(1);
            String email = cellValues.get(2);
            String name = cellValues.get(3);
            addUser(new User(null, username, password, email, name, Role.USER.getStatus(), null, null, null), userID);
        }
        file.delete();
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
    public int editUser(User user, Integer userID) {
        if(user.getId() == null)
            return addUser(user, userID);
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
