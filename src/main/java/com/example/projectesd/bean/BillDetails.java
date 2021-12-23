package com.example.projectesd.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class BillDetails implements Serializable {
    static int billcnt=0;
    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billid;

    @Column(nullable = false)
    private String billedDate;

    @Column(nullable = false)
    private double amt;

    public BillDetails(){}
    public BillDetails(String billedDate, double amt) {
        System.out.println(billcnt);
        this.billid=++billcnt;
        this.billedDate = billedDate;
        this.amt = amt;
    }

    public String getBilledDate() {
        return billedDate;
    }

    public void setBilledDate(String billedDate) {
        this.billedDate = billedDate;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
}
