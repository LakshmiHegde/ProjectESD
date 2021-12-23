package com.example.projectesd.DAO.Implementation;

import com.example.projectesd.DAO.BillDAO;
import com.example.projectesd.bean.BillDetails;
import com.example.projectesd.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDetailsDAOImpl implements BillDAO {
    public BillDetails addBill(BillDetails b)
    {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();
            System.out.println("Ading bill");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String d=formatter.format(date);
            System.out.println("d= "+d+" cls= "+d.getClass());

            String sql="Insert into BillDetails values ("+b.getBillid()+","+d.toString()+","+b.getAmt()+")";
            Query q=session.createSQLQuery(sql);
            int x=q.executeUpdate();
            if(x == 0)
                return null;
            //System.out.println("x= "+x);
            b.setBilledDate(d);

            System.out.println("Added bill");
            t.commit();
            return b;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    public List<BillDetails> readAll()
    {

        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();
            List<BillDetails> bills = new ArrayList<>();

            for (final Object bill : session.createQuery("from BillDetails ").list())
                bills.add((BillDetails) bill);

            t.commit();
            return bills;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}
