package vn.DungVipPro.restAPIAndHibernate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;
import vn.DungVipPro.restAPIAndHibernate.service.Interface_Service;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private Interface_Service service;

    @Autowired
    public StudentController(@Qualifier("studentService") Interface_Service studentService) {
        this.service = studentService;
    }

    @GetMapping("/{firstName}")
    public List<Student> findByFirstNameNotContains(@PathVariable String firstName){
        return this.service.findByFirstNameNotContains(firstName);
    }
}
