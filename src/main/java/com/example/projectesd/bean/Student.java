package com.example.projectesd.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private BillDetails bill;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    private double dueAmount;

    @ManyToOne //many stud to one course
    private CourseFeeStr course;

    public Student()
    {}

    public Student(Integer id,BillDetails bid, double dueamt, CourseFeeStr cid, String status) {
        this.id=id;
        this.bill = bill;
        this.dueAmount = dueamt;
        this.course = cid;

    }

    public BillDetails getBill() {
        return bill;
    }

    public void setBill(BillDetails bid) {
        this.bill = bid;
    }


    public CourseFeeStr getCourse() {
        return course;
    }

    public void setCourse(CourseFeeStr course) {
        this.course = course;
    }
}
