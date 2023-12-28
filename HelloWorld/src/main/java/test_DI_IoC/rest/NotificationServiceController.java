package test_DI_IoC.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test_DI_IoC.service.EmailService;
import test_DI_IoC.service.MessageInterface;

@RestController
public class NotificationServiceController {
    private MessageInterface service;
    @Autowired
    public NotificationServiceController(@Qualifier("smsService") MessageInterface service){
        this.service = service;
    }

    @GetMapping("/send-email-service")
    public String emailSend(){
        return this.service.sendMessage();
    }
}
