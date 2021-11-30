package com.example.pfotenfreunde.model.feed;

import com.example.pfotenfreunde.model.Picture;
import com.example.pfotenfreunde.model.user.User;

import java.util.Date;

public class Post {
    private int id;
    private User sender;
    private Date postedAt;
    private Picture picture;
    private String msg;

    public Post(int id, User sender, Date postedAt, Picture picture, String msg) {
        this.id = id;
        this.sender = sender;
        this.postedAt = postedAt;
        this.picture = picture;
        this.msg = msg;
    }

    public Post(int id, User sender, Date postedAt, String msg) {
        this.id = id;
        this.sender = sender;
        this.postedAt = postedAt;
        picture = null;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean hasPicture(){
        return picture!=null;
    }
}

