package vn.DungVipPro.restAPIAndHibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

import java.util.List;

@Repository
public class StudentDAO implements  Interface_DAO<Student>{
    private EntityManager entityManager;

    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Boolean insertG(Student student) {
        Boolean check = false;
        try {
            this.entityManager.persist(student);
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    @Transactional
    public Boolean deleteG(Student student) {
        Boolean check = false;
        try {
            if(this.selectG(student) != null){
                this.entityManager.remove(student);
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    @Transactional
    public Boolean updateG(Student student) {
        Boolean check = false;
        try {
            if(this.selectG(student) != null){
                this.entityManager.merge(student);
                this.entityManager.flush();
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Student selectG(Student student) {
        Student st = null;
        try {
            st = this.entityManager.find(Student.class, student.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> list = null;
        try {
            list = this.entityManager.createQuery("FROM Student").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
