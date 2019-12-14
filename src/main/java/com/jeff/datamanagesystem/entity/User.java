package com.jeff.datamanagesystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = { "handler", "columns"})
public class User {

    public static final String[] columns = new String[]{
            "id", "username", "name", "password", "email", "status", "creator_id", "create_time", "update_time"
    };

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String name;
    private Integer status;
    private String statusName;
    private Integer creatorID;
    private Date createTime;
    private Date updateTime;

    public User() {
    }

    public User(Integer id, String username, String password, String email, String name, Integer status, Integer creatorID, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.status = status;
        this.creatorID = creatorID;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public static String[] getColumns() {
        return columns;
    }

    public Integer getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Integer creatorID) {
        this.creatorID = creatorID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
