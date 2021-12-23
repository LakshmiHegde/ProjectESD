package com.example.projectesd.DAO.Implementation;

import com.example.projectesd.DAO.CourseDAO;
import com.example.projectesd.bean.BillDetails;
import com.example.projectesd.bean.CourseFeeStr;
import com.example.projectesd.bean.UpdateCourse;
import com.example.projectesd.bean.UpdateDate;
import com.example.projectesd.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean updateCourseFee(UpdateCourse s)
    {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();
            String query="UPDATE CourseFeeStr set fee = fee + "+s.getFee()+" where cid= "+s.getCid();
            Query q=session.createSQLQuery(query);
            int x=q.executeUpdate();
            t.commit();
            if(x == 0)
                return false;
            else
                return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }
    public boolean updateCourseDate(UpdateDate s)
    {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();
            String query="UPDATE CourseFeeStr set date = "+s.getDate()+" where cid= "+s.getCid();
            Query q=session.createSQLQuery(query);
            int x=q.executeUpdate();
            t.commit();
            if(x == 0)
                return false;
            else
                return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }
    public boolean addcourse(CourseFeeStr s)
    {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();
            session.save(s);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }

    public List<CourseFeeStr> readAll()
    {

        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();
            List<CourseFeeStr> bills = new ArrayList<>();

            for (final Object bill : session.createQuery("from CourseFeeStr").list())
                bills.add((CourseFeeStr) bill);

            t.commit();
            return bills;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

}
