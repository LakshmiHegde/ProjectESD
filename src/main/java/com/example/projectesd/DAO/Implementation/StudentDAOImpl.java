package com.example.projectesd.DAO.Implementation;

import com.example.projectesd.DAO.StudentDAO;
import com.example.projectesd.bean.BillDetails;
import com.example.projectesd.bean.CourseFeeStr;
import com.example.projectesd.bean.Student;
import com.example.projectesd.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean updateStudent(Integer sid, double fee)
    {
        try (Session session = HibernateSessionUtil.getSession()) {
            String sql="Update Student set dueAmount= dueAmount - "+fee+" where id= "+sid;
            Transaction t=session.beginTransaction();
            Query qr=session.createSQLQuery(sql);
            int x= qr.executeUpdate();
            if(x == 0)
                return false;
            System.out.println("updated "+x+" records");

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            BillDetails s=new BillDetailsDAOImpl().addBill(new BillDetails(null,fee));

            sql="Update Student set bill_billid= "+s.getBillid()+" where id= "+sid;
            qr=session.createSQLQuery(sql);

            x= qr.executeUpdate();
            System.out.println("updated "+x+" records");

            t.commit();
            return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }

    public boolean add(Student b)
    {
        try (Session session = HibernateSessionUtil.getSession()) {
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
        return true;
    } catch (HibernateException exception) {
        System.out.print(exception.getLocalizedMessage());
    }
        return false;
    }

    public List<Student> readAll()
    {

        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();
            List<Student> bills = new ArrayList<>();

            for (final Object bill : session.createQuery("from Student ").list())
                bills.add((Student) bill);

            t.commit();
            return bills;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

}
