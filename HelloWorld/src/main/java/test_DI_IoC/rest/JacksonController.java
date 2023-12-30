package test_DI_IoC.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import test_DI_IoC.service.StudentPOJO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
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
        for(StudentPOJO st : this.list){
            if(st.getId().equals(id)){
                return st;
            }
        }
        return null;
    }

    @GetMapping("/index")
    public StudentPOJO findStudentWithIndex(@RequestParam("id") Integer id){
        return this.list.get(id);
    }
}
