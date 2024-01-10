package test_DI_IoC.service;

import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageInterface{
    public ZaloService(){
        System.out.println("This is constructor of : " + this.getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Zalo sending ....";
    }
}
