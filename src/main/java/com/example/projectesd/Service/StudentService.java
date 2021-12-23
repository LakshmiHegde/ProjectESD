package com.example.projectesd.Service;

import com.example.projectesd.DAO.Implementation.StudentDAOImpl;

import com.example.projectesd.bean.Student;
import com.example.projectesd.bean.UpdateClass;

import java.util.List;


public class StudentService {
    StudentDAOImpl s=new StudentDAOImpl();
    public boolean update(UpdateClass s1)
    {
        return s.updateStudent(s1.getSid(), s1.getFee());
    }

    public boolean add(Student stud)
    {
        return s.add(stud);
    }
    public List<Student> read() {
        return s.readAll();
    }
}
