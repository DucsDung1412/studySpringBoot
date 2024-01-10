package test_DI_IoC.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test_DI_IoC.service.MessageInterface;

@RestController
public class CheckScopeController {
    private MessageInterface mess1;
    private MessageInterface mess2;

    @Autowired
    public CheckScopeController(@Qualifier("emailService")MessageInterface mess1, @Qualifier("emailService")MessageInterface mess2) {
        this.mess1 = mess1;
        this.mess2 = mess2;
    }

    @GetMapping("/check")
    public String check(){
        if(mess1==mess2){
            return "SINGLETON";
        } else {
            return "PROTOTYPE";
        }
    }
}
