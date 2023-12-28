package test_DI_IoC.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test_DI_IoC.service.EmailService;
import test_DI_IoC.service.MessageInterface;

@RestController
public class NotificationPrimaryController {
    private MessageInterface service;
    @Autowired
    public NotificationPrimaryController(MessageInterface service){
        this.service = service;
    }

    @GetMapping("/send-email-primary")
    public String emailSend(){
        return this.service.sendMessage();
    }
}
