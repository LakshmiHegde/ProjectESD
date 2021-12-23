package com.example.projectesd.bean;

public class UpdateCourse {
    private int cid,fee;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
    public UpdateCourse(){}
    public UpdateCourse(int cid, int fee) {
        this.cid = cid;
        this.fee = fee;
    }
}
