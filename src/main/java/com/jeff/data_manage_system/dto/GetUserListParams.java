package com.jeff.data_manage_system.dto;

import com.jeff.data_manage_system.entity.User;

public class GetUserListParams {
    private User user;
    private ListParams listParams;

    public GetUserListParams() {
    }

    public GetUserListParams(User user, ListParams listParams) {
        this.user = user;
        this.listParams = listParams;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ListParams getListParams() {
        return listParams;
    }

    public void setListParams(ListParams listParams) {
        this.listParams = listParams;
    }

    @Override
    public String toString() {
        return "GetUserListParams{" +
                "user=" + user +
                ", listParams=" + listParams +
                '}';
    }
}
