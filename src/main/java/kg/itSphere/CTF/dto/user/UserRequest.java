package kg.itSphere.CTF.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {
    @Size(min = 6, max = 15, message = "Invalid first name! (Character(6 - 15)")
    private String firstName;
    @Size(min = 6, max = 15, message = "Invalid last name! (Character(6 - 15)")
    private String lastName;
    @Size(min = 4, max = 20, message = "Invalid email name! (Character(4 - 20)")
    @NotNull
    private String email;
    @Size(min = 6, max = 12, message = "Invalid password name! (Character(6 - 12)")
    @NotNull
    private String password;
}
