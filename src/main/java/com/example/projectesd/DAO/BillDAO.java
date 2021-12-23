package com.example.projectesd.DAO;

import com.example.projectesd.bean.BillDetails;

import java.util.List;

public interface BillDAO {
    public BillDetails addBill(BillDetails b);
    public List<BillDetails> readAll();
}
