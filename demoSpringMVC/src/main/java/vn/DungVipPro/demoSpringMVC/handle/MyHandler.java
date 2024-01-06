package vn.DungVipPro.demoSpringMVC.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.DungVipPro.demoSpringMVC.service.ErrorService;

@ControllerAdvice
public class MyHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorService> checkErr(Exception e){
        ErrorService er = new ErrorService(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }
}
