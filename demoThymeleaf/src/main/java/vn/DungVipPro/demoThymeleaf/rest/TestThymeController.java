package vn.DungVipPro.demoThymeleaf.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestThymeController {
    @GetMapping("/test-thymeleaf/{id}")
    public String testThyme(@PathVariable int id, Model model){
        model.addAttribute("num", id);
        return "bang-cuu-chuong";
    }
}
