package com.example.projectesd.Service;

import com.example.projectesd.DAO.Implementation.BillDetailsDAOImpl;
import com.example.projectesd.bean.BillDetails;

import java.util.List;

public class BillService {
    BillDetailsDAOImpl s=new BillDetailsDAOImpl();
    public boolean addBill(BillDetails d) {
        BillDetails res=s.addBill(d);
        if(res == null)
            return false;
        return true;
    }

    public List<BillDetails> read() {
        return s.readAll();
    }
}
