package com.example.pfotenfreunde.model.user;

import java.util.ArrayList;
import java.util.List;

public class Institution extends User{
    private String homePage;
    private List<User> userList;

    public Institution(String name, String phone, String email, Address address, String homePage, List<User> userList) {
        super(name, phone, email, address);
        this.homePage = homePage;
        this.userList = userList;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public List<User> getUserList() {
        return userList;
    }
}
