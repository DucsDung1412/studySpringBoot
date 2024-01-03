package temp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import temp.service.Interface_Service;
import vn.DungVipPro.restAPIAndHibernate.entity.Student;

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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
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
                return ResponseEntity.status(HttpStatus.OK).body(student);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
        Student student = new Student();
        student.setId(id);
        if(this.service.getG(student) != null){
            Boolean check = this.service.deleteG(student);
            if(check){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
