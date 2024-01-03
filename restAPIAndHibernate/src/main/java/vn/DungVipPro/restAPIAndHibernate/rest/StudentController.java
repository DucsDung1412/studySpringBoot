package vn.DungVipPro.restAPIAndHibernate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.DungVipPro.restAPIAndHibernate.dao.Interface_DAO2;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private Interface_DAO2 service;

    @Autowired
    public StudentController(Interface_DAO2 studentService) {
        this.service = studentService;
    }

    @GetMapping("/{firstName}")
    public List<Student> getStudentByID(@PathVariable String firstName){
        return this.service.findByFirstNameNotContains(firstName);
    }
}
