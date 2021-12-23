package com.example.projectesd.DAO;

import com.example.projectesd.bean.BillDetails;
import com.example.projectesd.bean.Student;

import java.util.List;

public interface StudentDAO {
    public boolean updateStudent(Integer sid,double fee);
    public boolean add(Student s);
    public List<Student> readAll();
}
