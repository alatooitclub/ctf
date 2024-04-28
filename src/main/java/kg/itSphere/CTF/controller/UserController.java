package kg.itSphere.CTF.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import kg.itSphere.CTF.dto.user.UserRequest;
import kg.itSphere.CTF.dto.user.UserResponse;
import kg.itSphere.CTF.services.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final MyUserService userService;

    @GetMapping("/all")
    List<UserResponse> all() {
        return userService.all();
    }

    @GetMapping("/findByEmail")
    UserResponse findByEmail(@RequestParam(value = "email") String email) {
        return userService.findByEmail(email);
    }

    @PutMapping("/updateById")
    void updateById(@NotNull @RequestParam(value = "id") Long id, @Valid @RequestBody UserRequest userRequest) {
        userService.updateById(id, userRequest);
    }

    @DeleteMapping("/deleteById")
    void deleteById(@NotNull @RequestParam(value = "id") Long id) {
        userService.deleteById(id);
    }
}
