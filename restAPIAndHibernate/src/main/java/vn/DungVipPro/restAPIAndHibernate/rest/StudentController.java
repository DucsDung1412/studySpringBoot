package vn.DungVipPro.restAPIAndHibernate.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public List<Student> getAllStudent(){
        return this.service.getList();
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable Integer id){
        Student st = new Student();
        st.setId(id);
        return (Student)this.service.getG(st);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Boolean check = this.service.addG(student);
        if(check){
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student){
        Student st = new Student();
        st.setId(id);
        if(this.service.getG(st) != null){
            Student g = (Student) this.service.getG(st);
            student.setId(st.getId());
            student.setEmail(student.getEmail() == null ? g.getEmail() : student.getEmail());
            student.setFirstName(student.getFirstName() == null ? g.getFirstName() : student.getFirstName());
            student.setLastName(student.getLastName() == null ? g.getLastName() : student.getLastName());

            Boolean check = this.service.updateG(student);
            if(check){
                return ResponseEntity.status(HttpStatus.CREATED).body(student);
            }
        }
        return null;
    }
}
