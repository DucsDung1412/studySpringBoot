package vn.DungVipPro.restAPIAndHibernate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.DungVipPro.restAPIAndHibernate.dao.StudentDAO;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return this.studentDAO.selectAll();
    }

    @GetMapping("{id}")
    public Student getStudentByID(@PathVariable Integer id){
        Student st = new Student();
        st.setId(id);
        return this.studentDAO.selectG(st);
    }

}
