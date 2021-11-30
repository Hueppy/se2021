package com.example.pfotenfreunde.model;

import java.util.Date;

public class Picture {
    private String name;
    private String path;
    private Date uploadDate;

    public Picture(String name, String path, Date uploadDate) {
        this.name = name;
        this.path = path;
        this.uploadDate = uploadDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
