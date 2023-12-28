package vn.DungVipPro.HelloWorld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Đặt dự án springboot ở lớp này
@SpringBootApplication
// Quy định lớp này là controller
@RestController
public class DemoApplication {
    // Sử dụng dữ liệu thông qua properties
    @Value("${custom.one}")
    private String one;
    @Value("${custom.two}")
    private String two;
    @Value("${custom.three}")
    private String three;

    // main method
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // Tạo tham chiều cho controller
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "DungVipPro") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/love")
    public String customProperties(){
        return "<h1>"+one+ " " + three + " " + two + "</h1>";
    }

    @GetMapping("/devtools")
    public String testDevTools() {
        return "<h4>Devtools is the best !!!</h4>";
    }
}
