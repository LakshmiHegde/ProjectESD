package com.example.projectesd.Service;

import com.example.projectesd.DAO.Implementation.CourseDAOImpl;
import com.example.projectesd.bean.BillDetails;
import com.example.projectesd.bean.CourseFeeStr;
import com.example.projectesd.bean.UpdateCourse;
import com.example.projectesd.bean.UpdateDate;

import java.util.List;

public class CourseService {
    CourseDAOImpl s=new CourseDAOImpl();
    public boolean update(UpdateCourse c)
    {
        return s.updateCourseFee(c);
    }
    public boolean updateDate(UpdateDate c)
    {
        return s.updateCourseDate(c);
    }
    public boolean add(CourseFeeStr c)
    {
        return s.addcourse(c);
    }
    public List<CourseFeeStr> read() {
        return s.readAll();
    }
}
