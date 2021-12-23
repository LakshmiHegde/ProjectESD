package com.example.projectesd.bean;

public class UpdateDate {
    private int cid;
        String date;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UpdateDate()
    {}
    public UpdateDate(int cid, String date) {
        this.cid = cid;
        this.date = date;
    }
}
