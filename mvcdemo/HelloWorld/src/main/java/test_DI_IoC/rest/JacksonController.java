package test_DI_IoC.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test_DI_IoC.exception.StudentException;
import test_DI_IoC.service.ErrorResponse;
import test_DI_IoC.service.StudentPOJO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
@ServletComponentScan(basePackages = {"exception"})
public class JacksonController {
    private List<StudentPOJO> list;

    @PostConstruct
    public void createList(){
        this.list = new ArrayList<>();
        this.list.add(new StudentPOJO("1", "Dung", 23, true));
        this.list.add(new StudentPOJO("2", "Hanh", 22, false));
        this.list.add(new StudentPOJO("3", "Hung", 21, true));
        this.list.add(new StudentPOJO("4", "Sang", 23, true));
    }

    @GetMapping("/")
    public List<StudentPOJO> returnList(){
        return this.list;
    }

    @GetMapping("/{id}")
    public StudentPOJO findStudent(@PathVariable String id){
        StudentPOJO student = null;
        for(StudentPOJO st : this.list){
            if(st.getId().equals(id)){
                return st;
            }
        }
        if(student == null){
            throw new StudentException("Không tìm thấy studen có id = " + id);
        }
        return student;
    }

    @GetMapping("/index")
    public StudentPOJO findStudentWithIndex(@RequestParam("index") Integer index){
        if(index >= this.list.size() || index < 0){
            throw new StudentException("Không tìm thấy student ở index = " + index);
        } else {
            return this.list.get(index);
        }
    }

//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> batLoi(StudentException ex){
//        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> batLoi1(Exception ex){
//        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }
}
