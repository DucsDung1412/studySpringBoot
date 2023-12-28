package test_DI_IoC.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmsService implements MessageInterface{
    public SmsService(){
        System.out.println("This is constructor of : " + this.getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "SMS sending ....";
    }
}
