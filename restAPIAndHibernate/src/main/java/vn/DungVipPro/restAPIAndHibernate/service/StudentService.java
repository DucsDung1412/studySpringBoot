package vn.DungVipPro.restAPIAndHibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.DungVipPro.restAPIAndHibernate.dao.Interface_DAO2;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

import java.util.List;

@Service
public class StudentService implements Interface_Service<Student> {
    private Interface_DAO2 studentDAO;

    @Autowired
    public StudentService(Interface_DAO2 studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findByFirstNameNotContains(String firstName){
        return this.studentDAO.findByFirstNameNotContains(firstName);
    }
}
