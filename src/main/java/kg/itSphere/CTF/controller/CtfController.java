package kg.itSphere.CTF.controller;

import kg.itSphere.CTF.entities.Ctf;
import kg.itSphere.CTF.services.CtfService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ctf")
public class CtfController {
        private final CtfService ctfService;

}
