package kg.itSphere.CTF.controller;

import kg.itSphere.CTF.dto.auth.AuthRequest;
import kg.itSphere.CTF.dto.auth.AuthResponse;
import kg.itSphere.CTF.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest authRequest) {
        return authService.register(authRequest);
    }

    @GetMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @GetMapping("/secured")
    public String secured() {
        return "Secured endpoint";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin endpoint";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/register-form")
    public String registerForm() {
        return "register";
    }

    @GetMapping("/forgot-password-form")
    public String forgotPassword() {
        return "forgot-password";
    }
}
