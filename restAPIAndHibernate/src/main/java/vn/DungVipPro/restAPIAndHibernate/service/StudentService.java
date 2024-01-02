package vn.DungVipPro.restAPIAndHibernate.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.DungVipPro.restAPIAndHibernate.dao.StudentDAO;
import vn.DungVipPro.restAPIAndHibernate.dao.StudentRepository;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements  Interface_Service<Student> {
    private StudentDAO studentDAO;
    private StudentRepository stR;

    @Autowired
    public StudentService(StudentDAO studentDAO, StudentRepository stR) {
        this.studentDAO = studentDAO;
        this.stR = stR;
    }

    @Override
    public List<Student> getList() {
        return this.stR.getService().findAll();
    }

    @Override
    public Student getG(Student student) {
        Optional<Student> s = this.stR.getService().findById(student.getId());
        return s.get();
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
