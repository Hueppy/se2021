package com.example.pfotenfreunde.model.chat;

import com.example.pfotenfreunde.model.user.User;

import java.util.Date;
import java.util.List;

public class Chatroom {
    private int id;
    private List<User> members;
    private List<Message> messages;
    private Date startedAt;

    public Chatroom(int id, List<User> members, List<Message> messages, Date startedAt) {
        this.id = id;
        this.members = members;
        this.messages = messages;
        this.startedAt = startedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }
}
