package vn.DungVipPro.i18n;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyControlller{
    @GetMapping("/international")
    public String getInternationalPage() {
        return "/international";
    }

    @GetMapping("/change")
    public String cahnge(){
        return "/change";
    }
}
