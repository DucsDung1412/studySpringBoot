package vn.DungVipPro.demoAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
    @Before("execution (* vn.DungVipPro.demoAOP.service.CalculatorService.plus(..))")
    public void beforePlus(JoinPoint joinPoint){
        System.out.println("Running method plus in Calculator");
    }

    @After("execution (* vn.DungVipPro.demoAOP.service.CalculatorService.plus(..))")
    public void afterPlus(JoinPoint joinPoint){
        System.out.println("Done!");
    }
}
