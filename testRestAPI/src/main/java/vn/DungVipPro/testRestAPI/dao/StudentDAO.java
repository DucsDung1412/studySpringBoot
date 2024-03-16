package vn.DungVipPro.testRestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.testRestAPI.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Long> {

}
