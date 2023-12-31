package vn.DungVipPro.restAPIAndHibernate.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.DungVipPro.restAPIAndHibernate.dao.StudentDAO;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

import java.util.List;

@Service
public class StudentService implements  Interface_Service<Student> {
    private StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getList() {
        return this.studentDAO.selectAll();
    }

    @Override
    public Student getG(Student student) {
        return this.studentDAO.selectG(student);
    }

    @Override
    @Transactional
    public Boolean addG(Student student) {
        return this.studentDAO.insertG(student);
    }

    @Override
    @Transactional
    public Boolean deleteG(Student student) {
        return this.studentDAO.deleteG(student);
    }

    @Override
    @Transactional
    public Boolean updateG(Student student) {
        return this.studentDAO.updateG(student);
    }
}
