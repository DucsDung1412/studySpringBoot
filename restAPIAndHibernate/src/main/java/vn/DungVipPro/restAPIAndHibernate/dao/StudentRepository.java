package vn.DungVipPro.restAPIAndHibernate.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

@Repository
public class StudentRepository{
    private Interface_DAO2<Student> service;
    private EntityManager entity;
    @Autowired
    public StudentRepository(Interface_DAO2<Student> service, EntityManager entity){
       this.service = service;
       this.entity = entity;
    }

    public Interface_DAO2<Student> getService() {
        return service;
    }

    public void setService(Interface_DAO2<Student> service) {
        this.service = service;
    }

    public EntityManager getEntity() {
        return entity;
    }

    public void setEntity(EntityManager entity) {
        this.entity = entity;
    }
}
