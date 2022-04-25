package com.yph.pojo;


import java.util.Date;

public class Log {
    private Integer id;
    private String detail;
    private String date;

    public Log() {
    }

    public Log(String detail, String date) {
        this.detail = detail;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
