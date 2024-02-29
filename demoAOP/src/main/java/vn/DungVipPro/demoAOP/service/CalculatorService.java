package vn.DungVipPro.demoAOP.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double plus(double a, double b){
        return a + b;
    }

    public double substract(double a, double b){
        return a - b;
    }

    public double multiply(double a, double b){
        return a * b;
    }

    public double divide(double a, double b){
        return a/b;
    }
}
