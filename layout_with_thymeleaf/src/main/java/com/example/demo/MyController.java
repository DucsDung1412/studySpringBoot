package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MyController {
    @GetMapping("/")
    String index(Principal principal, Model model) {
        model.addAttribute("errorMessage", "Huhuhuhuhuhu");
        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
    }
}
