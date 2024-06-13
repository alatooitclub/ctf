package kg.itSphere.CTF.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import kg.itSphere.CTF.dto.user.UserRequest;
import kg.itSphere.CTF.dto.user.UserResponse;
import kg.itSphere.CTF.entities.Image;
import kg.itSphere.CTF.services.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final MyUserService userService;

    @GetMapping("/all")
    public List<UserResponse> all() {
        return userService.all();
    }

    @GetMapping("/findByEmail")
    public UserResponse findByEmail(@RequestParam(value = "email") String email) {
        return userService.findByEmail(email);
    }

    @PutMapping("/updateById")
    public void updateById(@NotNull @RequestParam(value = "id") Long id,
                           @RequestParam(value = "image") Image image,
                           @Valid @RequestBody UserRequest userRequest) {
        userService.updateById(id, userRequest, image);
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@NotNull @RequestParam(value = "id") Long id) {
        userService.deleteById(id);
    }


    @GetMapping
    public String showProfile(Model model){
        model.addAttribute("logoFileName", "src/main/resources/static/profile/alatoo-logo.png");
        return "profile";
    }
}
