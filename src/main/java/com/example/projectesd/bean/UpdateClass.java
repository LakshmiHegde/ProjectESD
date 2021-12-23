package com.example.projectesd.bean;

public class UpdateClass {
    private int sid;
    private double fee;
    private String course;

    public String getCourse() {
        return course;
    }
    public UpdateClass(){}
    public void setCourse(String course) {
        this.course = course;
    }

    UpdateClass(int sid, double fee ,String course)
    {
        this.sid=sid;
        this.fee=fee;
        this.course=course;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
