package com.jeff.datamanagesystem.enums;

import java.util.*;

public enum Role {

    USER("user", 0),
    ADMIN("admin", 1);

    private String name;
    private int status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    Role(String name, int status){
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}