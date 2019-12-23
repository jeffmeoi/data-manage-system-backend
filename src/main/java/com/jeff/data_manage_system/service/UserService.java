package com.jeff.data_manage_system.service;

import com.jeff.data_manage_system.entity.User;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;


public interface UserService {
    List getTotalCount();
    int addUser(User user, Integer userID);
    void addUsers(File file, Integer userID) throws IOException;
    int updateUser(User user);
    int editUser(User user, Integer userID);
    int deleteUser(Integer id);
    User getUser(Integer id);
    User getUser(String username);
    List<User> getUserList(User user);
    int login(HttpSession session, String username, String password) throws LoginException;
    int getLoginID(HttpSession session);
    void logout(HttpSession session);
}
