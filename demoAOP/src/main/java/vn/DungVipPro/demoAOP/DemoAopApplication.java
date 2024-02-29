package vn.DungVipPro.demoAOP;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.DungVipPro.demoAOP.service.CalculatorService;

@SpringBootApplication
public class DemoAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(CalculatorService calculatorService){
		return runner -> {
			double resultPlus = calculatorService.plus(5, 10);
			System.out.println(resultPlus);
		};
	}
}
