package test_DI_IoC.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"test_DI_IoC.rest", "test_DI_IoC.application", "test_DI_IoC.service"})
// @ComponentScan(basePackages = {"test_DI_IoC.rest", "test_DI_IoC.application", "test_DI_IoC.service"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
