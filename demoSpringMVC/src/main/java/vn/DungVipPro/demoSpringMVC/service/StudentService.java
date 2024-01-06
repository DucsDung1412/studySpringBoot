package vn.DungVipPro.demoSpringMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.DungVipPro.demoSpringMVC.dao.Interface_DAO;
import vn.DungVipPro.demoSpringMVC.entity.Student;

import java.util.List;

@Service
public class StudentService implements Interface_Service<Student> {
    private Interface_DAO studentDAO;

    @Autowired
    public StudentService(Interface_DAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Interface_DAO getStudentDAO() {
        return studentDAO;
    }
}
