package kg.itSphere.CTF.controller;

import jakarta.validation.constraints.NotNull;
import kg.itSphere.CTF.dto.role.RoleRequest;
import kg.itSphere.CTF.dto.role.RoleResponse;
import kg.itSphere.CTF.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/all")
    public List<RoleResponse> all() {
        return roleService.all();
    }

    @PutMapping("/updateById")
    public void updateById(@NotNull @RequestParam Long id, @RequestBody RoleRequest request) {
        roleService.updateById(id, request);
    }

    @PostMapping("/create")
    public void create(@RequestBody RoleRequest request) {
        roleService.create(request);
    }
}
