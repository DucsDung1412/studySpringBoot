package test_DI_IoC.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test_DI_IoC.service.EmailService;
import test_DI_IoC.service.MessageInterface;

@RestController
public class NotificationController {
    private EmailService email;
    @Autowired
    public NotificationController (EmailService email){
        this.email = email;
    }

    @GetMapping("/send-email")
    public String emailSend(){
        return this.email.sendMessage();
    }
}
