package vn.DungVipPro.restAPIAndHibernate.service;


import vn.DungVipPro.restAPIAndHibernate.entity.Student;

import java.util.List;

public interface Interface_Service<G> {
    public List<Student> findByFirstNameNotContains(String firstName);
}
