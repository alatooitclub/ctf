package kg.itSphere.CTF.dto.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private Long id;
    private String name;
    private String category;
    private String imagePath;
    private String author;
    private String points;
    private String status;
}
