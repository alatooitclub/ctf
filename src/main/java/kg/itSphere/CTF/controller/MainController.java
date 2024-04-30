package kg.itSphere.CTF.controller;

import jdk.jfr.Registered;
import kg.itSphere.CTF.services.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;
    @GetMapping
    public String showMainPage(){
        return "main";
    }
}