package com.example.pfotenfreunde.model.chat;

import com.example.pfotenfreunde.model.user.User;

import java.util.Date;

public class Message {
    private int id;
    private Date sendAt;
    private Date seenAt;
    private String msg;
    private User sender;

    public Message(int id, Date sendAt, Date seenAt, String msg, User sender) {
        this.id = id;
        this.sendAt = sendAt;
        this.seenAt = seenAt;
        this.msg = msg;
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSendAt() {
        return sendAt;
    }

    public void setSendAt(Date sendAt) {
        this.sendAt = sendAt;
    }

    public Date getSeenAt() {
        return seenAt;
    }

    public void setSeenAt(Date seenAt) {
        this.seenAt = seenAt;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
