package com.jeff.datamanagesystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"handler", "columns"})
public class Type {
    public static final String[] columns = new String[]{
            "id", "name", "description", "user_id", "create_time", "update_time"
    };

    private Integer id;// no need
    private String name;
    private String description;
    private Integer userID;// no need
    private Date createTime;// no need
    private Date updateTime;// no need

    public Type() {
    }

    public Type(Integer id, String name, String description, Integer userID, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userID = userID;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userID=" + userID +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
