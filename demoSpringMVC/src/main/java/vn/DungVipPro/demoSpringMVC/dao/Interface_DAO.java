package vn.DungVipPro.demoSpringMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.demoSpringMVC.entity.Student;

import java.util.List;

@Repository
public interface Interface_DAO<G> extends JpaRepository<Student, Integer> {
    public List<Student> findByFirstNameNotContains(String firstName);
}
