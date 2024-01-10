package test_DI_IoC.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MappingController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("hello/vietnamese")
    public String xinChao(){
        return "Xin chao";
    }

}
