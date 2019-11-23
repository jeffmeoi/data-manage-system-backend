package com.jeff.datamanagesystem.service;

import com.jeff.datamanagesystem.entity.User;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;
import java.util.List;


public interface UserService {
    List getTotalCount();
    int addUser(User user);
    int updateUser(User user);
    int editUser(User user);
    int deleteUser(Integer id);
    User getUser(Integer id);
    User getUser(String username);
    List<User> getUserList(User user);
    int login(HttpSession session, String username, String password) throws LoginException;
    int getLoginID(HttpSession session);
    void logout(HttpSession session);
}
