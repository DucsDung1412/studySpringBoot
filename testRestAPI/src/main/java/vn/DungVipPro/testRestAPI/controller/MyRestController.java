package vn.DungVipPro.testRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.DungVipPro.testRestAPI.dao.SchoolDAO;
import vn.DungVipPro.testRestAPI.dao.StudentDAO;
import vn.DungVipPro.testRestAPI.model.School;
import vn.DungVipPro.testRestAPI.model.Student;

import java.util.*;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private SchoolDAO schoolDAO;
    @GetMapping("/getStudents")
    public List<Map<String, Object>> getStudent(){
        List<Student> list = studentDAO.findAll();
        List<Map<String, Object>> listMap = new ArrayList<>();
        list.forEach(s -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", s.getId());
            map.put("name", s.getName());
            map.put("school", s.getClass_id().getId());
            listMap.add(map);
        });
        return listMap;
    }

    @GetMapping("/getStudent/{id}")
    public Map<String, Object> getStudent(@PathVariable Long id){
        Map<String, Object> student = new HashMap<>();
        student.put("id", studentDAO.findById(id).get().getId());
        student.put("name", studentDAO.findById(id).get().getName());
        student.put("school", studentDAO.findById(id).get().getClass_id().getId());
        return student;
    }

    /*
        @GetMapping("/getStudent")
        public Map<String, Object> getStudent(@RequestParam Long id){
            Map<String, Object> student = new HashMap<>();
            student.put("id", studentDAO.findById(id).get().getId());
            student.put("name", studentDAO.findById(id).get().getName());
            student.put("school", studentDAO.findById(id).get().getClass_id().getId());
            return student;
        }
     */

    @PostMapping("/insertStudent")
    public Map<String, Object> insertStudent(@RequestBody Student st){
//        System.out.println(school);
        System.out.println(st);
        School s = schoolDAO.findById(1L).get();
        st.setClass_id(s);
        studentDAO.save(st);
        Map<String, Object> student = new HashMap<>();
        student.put("id", st.getId());
        student.put("name", st.getName());
        student.put("school", st.getClass_id().getId());
        return student;
    }
}
