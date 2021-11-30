package com.example.pfotenfreunde.model.report;

import java.util.Date;

public class Report {
    private int id;
    private Date SendAt;
    private Date updatedAt;
    private String comment;
    private ReportType reportType;
    private ReportStatusType reportStatusType;

    public Report(int id, Date sendAt, Date updatedAt, String comment, ReportType reportType, ReportStatusType reportStatusType) {
        this.id = id;
        SendAt = sendAt;
        this.updatedAt = updatedAt;
        this.comment = comment;
        this.reportType = reportType;
        this.reportStatusType = reportStatusType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSendAt() {
        return SendAt;
    }

    public void setSendAt(Date sendAt) {
        SendAt = sendAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public ReportStatusType getReportStatusType() {
        return reportStatusType;
    }

    public void setReportStatusType(ReportStatusType reportStatusType) {
        this.reportStatusType = reportStatusType;
    }
}
