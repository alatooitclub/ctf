package kg.itSphere.CTF.dto.role;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoleRequest {
    @NotNull
    private String name;
}
