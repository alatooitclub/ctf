package kg.itSphere.CTF.dto.task;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class TaskRequest {
    @NotEmpty(message = "Name can't be empty")
    private String name;
    private String description;
    private String category;
    @NotEmpty(message = "Flag can't be empty")
    private String flag;
    private String hint;
    private String difficulty;
    private Integer rating;
    private Integer points;
    private String status;
}
