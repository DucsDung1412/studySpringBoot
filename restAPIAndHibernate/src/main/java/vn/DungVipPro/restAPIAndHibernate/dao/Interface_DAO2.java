package vn.DungVipPro.restAPIAndHibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

@Repository
public interface Interface_DAO2<G> extends JpaRepository<Student, Integer> {

}
