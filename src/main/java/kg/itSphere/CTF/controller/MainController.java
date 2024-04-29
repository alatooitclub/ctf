package kg.itSphere.CTF.controller;

import jdk.jfr.Registered;
import kg.itSphere.CTF.services.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;
}
