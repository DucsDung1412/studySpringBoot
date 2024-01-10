package test_DI_IoC.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmailService implements MessageInterface{
    public EmailService(){
        System.out.println("This is constructor of : " + this.getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Email sending .....";
    }
}
