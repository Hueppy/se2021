package com.example.pfotenfreunde.model.friend;

import com.example.pfotenfreunde.model.user.User;

import java.util.List;

public class Friendlist {
    private int id;
    private List<User> userList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int size(){
        return userList.size();
    }
}
