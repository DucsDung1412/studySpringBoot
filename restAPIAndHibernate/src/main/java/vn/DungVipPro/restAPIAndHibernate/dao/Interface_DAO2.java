package vn.DungVipPro.restAPIAndHibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

import java.util.List;

@RepositoryRestResource(path = "students")
public interface Interface_DAO2<G> extends JpaRepository<Student, Integer> {
    public List<Student> findByFirstNameNotContains(String firstName);
}
