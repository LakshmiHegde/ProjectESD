package com.example.projectesd.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class CourseFeeStr implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @OneToMany(mappedBy = "course") //one course many students
    private List<Student> s;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Column(nullable = false, unique = true)
    private String coursename;

    @Column(nullable = false)
    private double fee;

    @Column(nullable = false)
    private String date;

    public CourseFeeStr()
    {}
    public CourseFeeStr(String course,double fee, String date) {
        this.coursename=course;
        this.fee = fee;
        this.date = date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public List<Student> getS() {
        return s;
    }


    public void setS(List<Student> s)
    {
        this.s = s;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public double getFee() {
        return fee;
    }

    public String getDate() {
        return date;
    }
}

