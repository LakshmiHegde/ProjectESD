package com.example.projectesd.DAO;

import com.example.projectesd.bean.*;

import java.util.List;

public interface CourseDAO {
    public boolean updateCourseFee(UpdateCourse c);
    public boolean addcourse(CourseFeeStr s);
    public boolean updateCourseDate(UpdateDate s);
    public List<CourseFeeStr> readAll();
}
