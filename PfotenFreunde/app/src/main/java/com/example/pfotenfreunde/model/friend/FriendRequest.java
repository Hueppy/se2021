package com.example.pfotenfreunde.model.friend;

import com.example.pfotenfreunde.model.user.User;

import java.util.Date;

public class FriendRequest {
    private int id;
    private User sender;
    private User reciever;
    private Date sendAt;
    private Date seenAt;

    public FriendRequest(int id, User sender, User reciever, Date sendAt, Date seenAt) {
        this.id = id;
        this.sender = sender;
        this.reciever = reciever;
        this.sendAt = sendAt;
        this.seenAt = seenAt;
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

    public User getReciever() {
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
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
}
