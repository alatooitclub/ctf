package kg.itSphere.CTF.controller;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.validation.Valid;
import kg.itSphere.CTF.dto.auth.AuthRegisterRequest;
import kg.itSphere.CTF.dto.auth.AuthRequest;
import kg.itSphere.CTF.dto.auth.AuthResponse;
import kg.itSphere.CTF.repository.UserRepository;
import kg.itSphere.CTF.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRegisterRequest authRegisterRequest) {
        return authService.register(authRegisterRequest);
    }

    @GetMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @GetMapping("/login-form")
    public String loginForm(Model model) {
        AuthRequest authRequest = new AuthRequest();
        model.addAttribute("authRequest", authRequest);
        return "login";
    }

    @GetMapping("/register-form")
    public String registerForm(Model model) {
        AuthRegisterRequest authRegisterRequest = new AuthRegisterRequest();
        model.addAttribute("authRegisterRequest", authRegisterRequest);
        return "register";
    }

    @GetMapping("/forgot-password-form")
    public String forgotPassword() {
        return "forgot-password";
    }

    @PostMapping("/do-register")
    public String registerNewUser(@Valid @ModelAttribute AuthRegisterRequest authRegisterRequest,
                                  BindingResult result,
                                  Model model) {
        if(result.hasErrors()) {
            log.debug("Validation errors during registration: {}", result.getAllErrors());
            model.addAttribute("authRegisterRequest", authRegisterRequest);
            return "register";
        }

        if(userRepository.findByEmail(authRegisterRequest.getEmail()).isPresent()) {
            log.debug("Email already registered: {}", authRegisterRequest.getEmail());
            model.addAttribute("EmailError", "Your email has been registered");
            return "register";
        }

        try {
            authService.register(authRegisterRequest);
            model.addAttribute("success", "User successfully registered");
        } catch (Exception e) {
            log.error("Server error during registration", e);
            model.addAttribute("serverError", "Cannot register user, server error!");
            return "register";
        }
        return "redirect:/auth/home";
    }

    @PostMapping("/do-login")
    public String loginProcess(@Valid @ModelAttribute AuthRequest authRequest,
                               BindingResult result,
                               Model model) {
        if(result.hasErrors()) {
            log.debug("Validation error during login operation: {}", result.getAllErrors());
            model.addAttribute("authRequest", authRequest);
            return "login";
        }

        if(userRepository.findByEmail(authRequest.getEmail()).isEmpty()) {
            log.debug("Email is not found: {}", authRequest.getEmail());
            model.addAttribute("EmailError", "Email is not correct");
            return "login";
        }

        try {
            authService.login(authRequest);
            model.addAttribute("success", "Successfully login");
        } catch (Exception e) {
            log.debug("Server error during login: {}", e.getMessage());
            model.addAttribute("PasswordError", "Password is not correct!");
            return "login";
        }
        return "redirect:/auth/register-form";
    }
}
