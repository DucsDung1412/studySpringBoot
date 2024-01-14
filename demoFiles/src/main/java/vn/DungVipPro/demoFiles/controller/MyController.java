package vn.DungVipPro.demoFiles.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.expression.Strings;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class MyController {
    @GetMapping("/home")
    public String goToHome(){
        return "/my-home";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestAttribute("files") MultipartFile[] files, Model model){
        List<String> list = new ArrayList<>();
        for(MultipartFile file : files){
            try {
                model.addAttribute("test64", Base64.getEncoder().encodeToString(file.getBytes()));

                File f = new File(new ClassPathResource(".").getFile().getPath() + "/static/images");
                if(!f.exists()){
                    f.mkdirs();
                }

                Path path = Paths.get(f.getAbsolutePath() + File.separator + file.getOriginalFilename());
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                list.add(file.getOriginalFilename());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        model.addAttribute("list", list);
        return "/show-image";
    }
}
