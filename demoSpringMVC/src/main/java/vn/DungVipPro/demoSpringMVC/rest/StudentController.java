package vn.DungVipPro.demoSpringMVC.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.DungVipPro.demoSpringMVC.dao.Interface_DAO;
import vn.DungVipPro.demoSpringMVC.entity.Student;
import vn.DungVipPro.demoSpringMVC.service.Interface_Service;
import vn.DungVipPro.demoSpringMVC.service.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    private Interface_Service service;

    @Autowired
    public StudentController(@Qualifier("studentService") Interface_Service studentService) {
        this.service = studentService;
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<Student> list = ((StudentService)this.service).getStudentDAO().findAll();
        model.addAttribute("students", list);
        return "/student/student-table";
    }

    @GetMapping("/student-form-add")
    public String studentController(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "/student/student-form";
    }

    @PostMapping("/student-save")
    public String studentControllerSave(@ModelAttribute("student") Student student,  RedirectAttributes redirectAttributes){
        ((StudentService)this.service).getStudentDAO().save(student);
        redirectAttributes.addFlashAttribute("mess", "Thong bao");
        return "redirect:/api/students/student-form-add";
    }

}
